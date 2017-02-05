package com.abe.service.home.impl;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.abe.entity.Code;
import com.abe.entity.InfoParents;
import com.abe.entity.Users;
import com.abe.entity.other.RespCommon;
import com.abe.service.home.iParentService;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.tools.HttpClientHelper;
import com.abe.tools.NameOfDate;

public class ParentServiceImpl extends BaseServiceImpl implements iParentService{

	private final String URL="http://v1.avatardata.cn/Sms/Send?key=4819b920396a48e88ca8cda04faecff9&templateId=4ff6b91579ab42b09cdaa5db820a14be";
	
	
	@Override
	public List<InfoParents> getAllParents() {
		return find("from InfoParents", null);
	}

	@Override
	public RespCommon addFromApp(String uid,InfoParents parent,String code) {
		RespCommon resp=new RespCommon();
		if (uid!=null && parent!=null && code!=null) {
			Users user=(Users) get(Users.class, uid);
			parent.setIpId(NameOfDate.getNum());
			Code co=(Code) get(Code.class, uid);
			Date date=new Date();
			//判断是否通过的标志
			boolean isGoto=false;
			if (user!=null && user.getUType().equals("1") && user.getTrpId()==null){
					isGoto=true;
			}else if (user.getTrpId()!=null && !user.getTrpId().trim().equals("")) {
				//看看这个uid是否已经有了parent了
				InfoParents p=(InfoParents) get(InfoParents.class, user.getTrpId());
				if (p==null) {
					isGoto=true;
				}else {
					isGoto=false;
					resp.setResult("004");
					resp.setData(null);
				}
			}
			if (isGoto && user!=null && co!=null && code.equals(co.getCCode()) &&
					uid.equals(co.getUId()) && date.before(co.getCNoTime())) {//验证码验证通过
				List<InfoParents> list=find("from InfoParents where ipPhone=?", new String[]{parent.getIpPhone()});
				if (list!=null) {
					if (list.size()==0) {//唯一性验证通过
						save(parent);
						user.setTrpId(parent.getIpId());
						update(user);
						resp.setResult("001");
						resp.setData(null);
					}else {//说明是在注册学生档案填写的家长档案
						user.setTrpId(list.get(0).getIpId());
						update(user);
						resp.setResult("003");
						resp.setData(null);
					}
				}
			}else {
				resp.setResult("002");
				resp.setData(null);
			}
		}
		return resp;
	}

	@Override
	public RespCommon getCode(String uid) {
		RespCommon resp=new RespCommon();
		if (uid!=null) {
			Code code=(Code) get(Code.class, uid);
			if (code!=null) {
				resp.setResult("001");
				resp.setData(null);
				return resp;
			}
		}
		resp.setResult("002");
		resp.setData(null);
		return resp;
	}

	
	
	@Override
	public boolean saveCode(String uid,String mobile,String param) {
		if (uid!=null && mobile!=null && param!=null) {
			List<NameValuePair> list=new ArrayList<NameValuePair>();
			list.add(new BasicNameValuePair("mobile", mobile));
			list.add(new BasicNameValuePair("param", param));
			try {
				System.out.println("1111111111111111111");
				String result=HttpClientHelper.getInstance().doPost(URL, list);
				System.out.println("2222222222222222");
				JSONObject jsonObject=JSONObject.fromObject(result);
				System.out.println("33333333333333333");
				String isSucc=null;
				try {
					isSucc=jsonObject.getString("success");
				} catch (Exception e) {
					System.out.println("--出错了--");
					return false;
				}
				System.out.println("isSucc:"+isSucc);
				System.out.println("4444444444444444444");
				if (isSucc!=null && isSucc.equals("true")) {
					Code ctmp=(Code) get(Code.class, uid);
					Date date=new Date();
					Calendar calendar=Calendar.getInstance();   
					calendar.setTime(date); 
					calendar.add(Calendar.MINUTE, 10);
					if (ctmp==null) {//该用户没有验证码
						Code code=new Code(uid, mobile, param, new Timestamp(date.getTime()),new Timestamp(calendar.getTime().getTime()));
						save(code);
					}else {//用户有验证码
						ctmp.setCPhone(mobile);
						ctmp.setCCode(param);
						ctmp.setCTime(new Timestamp(date.getTime()));
						ctmp.setCNoTime(new Timestamp(calendar.getTime().getTime()));
						update(ctmp);
					}
					return true;
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return false;
	}


	@Override
	public RespCommon queryParent(String uid) {
		RespCommon resp=new RespCommon();
		if (uid!=null) {
			Users user=(Users) get(Users.class, uid);
			if (user!=null && user.getUType()!=null && user.getUType().equals("1")) {
				InfoParents p=(InfoParents) get(InfoParents.class, user.getTrpId());
				if (p!=null) {
					resp.setResult("001");
					resp.setData(p);
					return resp;
				}
			}
		}
		resp.setResult("002");
		resp.setData(null);
		return resp;
	}
	
	
}
