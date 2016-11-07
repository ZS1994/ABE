package com.abe.action.home;


import org.apache.log4j.Logger;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.InfoTeacher;
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
