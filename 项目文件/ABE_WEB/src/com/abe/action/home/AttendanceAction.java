/**
 * 
 */
package com.abe.action.home;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.Users;
import com.abe.entity.app.RespCommon;
import com.abe.service.iBaseService;
import com.abe.service.home.iAttendanceService;

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
	private iBaseService ser;
	private iAttendanceService attendanceSer;
	
	private String result="attendance";
	private String result_fail="";
	
	private Logger logger=Logger.getLogger(AttendanceAction.class);
	
	
	
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
	
	
	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearOptions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearSpace() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String gotoQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryOfFenYe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

}
