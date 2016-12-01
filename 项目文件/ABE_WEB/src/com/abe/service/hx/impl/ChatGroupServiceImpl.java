package com.abe.service.hx.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.abe.action.home.InfoTeaAction;
import com.abe.entity.HxGroup;
import com.abe.entity.InfoTeacher;
import com.abe.entity.SchoolClass;
import com.abe.entity.Users;
import com.abe.service.hx.iChatgroupService;
import com.abe.service.hx.iUsersService;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.tools.Constant;
import com.abe.tools.HttpClientHelper;
import com.abe.tools.NameOfDate;
import com.sun.jmx.snmp.Timestamp;

public class ChatgroupServiceImpl extends BaseServiceImpl implements iChatgroupService{

	private iUsersService userSer;
	private Logger log=Logger.getLogger(ChatgroupServiceImpl.class);
	
	
	public iUsersService getUserSer() {
		return userSer;
	}
	public void setUserSer(iUsersService userSer) {
		this.userSer = userSer;
	}

	//------------------------------------------------------
	
	@Override
	public String addUser(String groupid, String username, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addUsers(String groupid, String[] usernames, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("static-access")
	@Override
	public String createChatgroup(String json, String token) {
		try {
			return HttpClientHelper.getInstance().doPost(Constant.ADDRESS_SOME+"chatgroups", json, token);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public String addChatgroup(SchoolClass schCla) {
		String groupid=null;//群组id，放着备用，有值代表成功，为null代表失败
		if (schCla!=null) {
			InfoTeacher tea=(InfoTeacher) get(InfoTeacher.class, schCla.getItId());
			List<Users> list=find("from Users where trpId=? and UType=2", new String[]{tea.getItId()});
			Users user=null;
			if (list.size()>0) {
				user=list.get(0);
			}
			if (tea!=null && user!=null) {
				//装填本地群组部分信息：即没有id
				HxGroup group=new HxGroup(null, schCla.getScName()+""+Calendar.getInstance().get(Calendar.YEAR)+"年"+(Calendar.getInstance().get(Calendar.MONTH)+1)+"月",
						user.getUId(), schCla.getScName()+""+Calendar.getInstance().get(Calendar.YEAR)+"年"+(Calendar.getInstance().get(Calendar.MONTH)+1)+"月。系统默认自动创建。", new java.sql.Timestamp(new Date().getTime()));
				log.debug(group.toString());
				//创建环信群组
				HashMap<String, Object> req=new HashMap<String, Object>();
				req.put("groupname",group.getGName());
				req.put("desc",group.getGDesc());
				req.put("public",true);
				req.put("maxusers",200);
				req.put("approval",true);
				req.put("owner",user.getUId());
				JSONObject json=objToJson(req);
				String token=userSer.getToken();
				try {
					String str=createChatgroup(json.toString(), token);
					JSONObject jsonObj=JSONObject.fromObject(str);
					groupid=jsonObj.getJSONObject("data").getString("groupid");
					//如果环信群组成功创建，那么本地也就保存
					if (groupid!=null && !groupid.trim().equals("")) {
						group.setGId(groupid);
						save(group);
					}
				} catch (Exception e) {
					log.error("群组保存失败，同时本地群组信息也不保存");
				}
			}
		}
		return groupid;
	}
	
	@Override
	public String deleteChatgroup(String groupid, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String overGroup(String groupid, String newowner, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryChatgroupUsers(String groupid, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryChatgroups(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryChatgroupsInfo(String token, String[] groupids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryGroupOfUser(String username, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeUser(String groupid, String username, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeUsers(String groupid, String[] usernames, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateChatgroup(String groupid, String json, String token) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
