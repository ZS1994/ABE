/**
 * 
 */
package com.abe.action.home;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.Card;
import com.abe.entity.CardLog;
import com.abe.entity.Users;
import com.abe.entity.other.RespCommon;
import com.abe.service.iBaseService;
import com.abe.service.home.iAttendanceService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;

/**
 * 张顺  2016年11月24日
 * 
 *<br/> 考勤管理
 *@author 张顺
 */
public class AttendanceAction extends BaseAction implements iBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger=Logger.getLogger(AttendanceAction.class);
	private iBaseService ser;
	private iAttendanceService attendanceSer;
	private String result="attendance";
	private Page page;
	private CardLog cl;
	private List<CardLog> cls;
	private String cz;
	private String id;
	
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public CardLog getCl() {
		return cl;
	}
	public void setCl(CardLog cl) {
		this.cl = cl;
	}
	public List<CardLog> getCls() {
		return cls;
	}
	public void setCls(List<CardLog> cls) {
		this.cls = cls;
	}
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	public iAttendanceService getAttendanceSer() {
		return attendanceSer;
	}
	public void setAttendanceSer(iAttendanceService attendanceSer) {
		this.attendanceSer = attendanceSer;
	}

	/**
	 * @author 张顺
	 * @param UId
	 * @return
	 * @throws IOException
	 * <br/>通过UId查询对应子女或教职工的考勤信息
	 */
	public String queryOfUid() throws IOException{
		logger.debug("-------------进入考勤信息查询------------");
		String UId=ser.clearSpace(getRequest(), "UId");
		RespCommon resp=new RespCommon();
		List list = null;
		if(UId==null){
			resp.setResult("003"); //接收到的UId为空
			resp.setData(null);
		}else{
			Users users = (Users) ser.get(Users.class, UId);
			if(users==null){
				resp.setResult("002");  //用户不存在
				resp.setData(null);
			}else{
				list = attendanceSer.queryOfUid(UId);
				resp.setResult("001");  //成功
				resp.setData(list);
			}
		}
		JSONObject json=ser.objToJson(resp);
		sendToApp(json, ser);
		return null;
	}
	
	public String addFromApp() {
		String cid=ser.clearSpace(getRequest(), "CId");
		String clState=ser.clearSpace(getRequest(), "clState");
		RespCommon resp=new RespCommon();
		if(cid!=null && clState!=null){
			Card card=(Card) ser.get(Card.class, cid);
			if (card!=null) {
				CardLog log=new CardLog(NameOfDate.getNum(), cid, new Timestamp(new Date().getTime()), clState);
				ser.save(log);
				resp.setResult("001");
				resp.setData(null);
			}else {
				resp.setResult("002");
				resp.setData(null);
			}
		}else {
			resp.setResult("002");
			resp.setData(null);
		}
		try {
			JSONObject json=ser.objToJson(resp);
			sendToApp(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void clearOptions() {
		cl=null;
		cls=null;
		cz=null;
		id=null;
	}

	@Override
	public void clearSpace() {
		cz=cz==null?null:cz.trim();
		id=id==null?null:id.trim();
	}
	@Override
	public String add() {
		clearSpace();
		return gotoQuery();
	}

	@Override
	public String delete() {
		clearSpace();
		return gotoQuery();
	}

	@Override
	public String gotoQuery() {
		clearSpace();
		clearOptions();
		if (page==null) {
			page=new Page(1, 0, 10);
		}else {
			page.setPageOn(1);
		}
		String hql="from CardLog order by clTime desc";
		cls=ser.query(hql, null, hql, page);
		for (int i = 0; i < cls.size(); i++) {
			cls.get(i).setSrtName(attendanceSer.getSrtName(cls.get(i).getCId()));
		}
		return result;
	}

	@Override
	public String queryOfFenYe() {
		clearSpace();
		if (cz!=null && "yes".equals(cz)) {
			clearOptions();
		}
		if (page==null) {
			page=new Page(1, 0, 10);
		}
		String hql="from CardLog where 1=1 ";
		if (id!=null) {
			hql=hql+"and clId like '%"+id+"%' ";
		}
		hql=hql+"order by clTime desc";
		cls=ser.query(hql, null, hql, page);
		for (int i = 0; i < cls.size(); i++) {
			cls.get(i).setSrtName(attendanceSer.getSrtName(cls.get(i).getCId()));
		}
		return result;
	}

	@Override
	public String update() {
		clearSpace();
		return gotoQuery();
	}

}
