package com.abe.action.home;


import java.io.IOException;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.InfoTeacher;
import com.abe.entity.Users;
import com.abe.entity.app.RespCommon;
import com.abe.entity.app.RespTeacher;
import com.abe.entity.app.RespUpdateUser;
import com.abe.service.iBaseService;
import com.abe.service.home.iTeacherService;

public class InfoTeaAction extends BaseAction implements iBaseAction {
    
	
	
	private static final long serialVersionUID = 1L;
	//service们
	private iBaseService ser;
	private iTeacherService teacherSer;
	//-------------
	private String result="teacherManager";
	private String result_fail="";
	
	private InfoTeacher teacher;
	
	private Logger logger=Logger.getLogger(InfoTeaAction.class);
	/**
	 * 卢江林 2016-11-21
	 * app通过uid查询教师资料
	 */
	public String queryFromAPP()throws IOException{
		String uid = ser.clearSpace(getRequest(), "UId");
		RespCommon respTeacher = new RespCommon();
		if(uid!=null){
			respTeacher.setResult("003");
			respTeacher.setData(null);
		}else{
			Users user = (Users) ser.get(Users.class, uid);
			if(user==null){
				respTeacher.setResult("002");
				respTeacher.setData(null);
			}else if(user.getUType().equals("2")){
				List<InfoTeacher> list = ser.find("from InfoTeacher where Uid=?", new String[]{user.getUId()});
				respTeacher.setResult("001");
				respTeacher.setData(null);
			}
		}
		JSONObject json = ser.objToJson(respTeacher);
		sendToApp(json,ser);
		return null;
	}
	
	/**
	 * @author lujianglin
	 * 查询老师的个人信息资料
	 * @param UId
	 * @throws IOException 
	 */
	public String queryTeacherFromApp(String uId) throws IOException{
		logger.debug("-------进入queryTeacherFromApp--------");
		String respTeacher = teacherSer.queryTeacher(uId);
		JSONObject jsonObject = ser.objToJson(respTeacher, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String gotoQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	public iBaseService getSer() {
		return ser;
	}

	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	public iTeacherService getTeacherSer() {
		return teacherSer;
	}

	public void setTeacherSer(iTeacherService teacherSer) {
		this.teacherSer = teacherSer;
	}

	public InfoTeacher getTeacher() {
		return teacher;
	}

	public void setTeacher(InfoTeacher teacher) {
		this.teacher = teacher;
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
	public String queryOfFenYe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
