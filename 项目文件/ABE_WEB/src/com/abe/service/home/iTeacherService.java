package com.abe.service.home;

import javax.servlet.http.HttpServletRequest;

import com.abe.entity.InfoTeacher;


public interface iTeacherService{
	
	/**卢江林<br>
	 * 通过工号查找老师   2016-11-6
	 * @param isNum 学号
	 * @return
	 */
	public InfoTeacher get(String isNum);
	
	/*
	public RespTeacher addFromApp(HttpServletRequest req);*/
	
	/**
	 * 测试request传过来是否可以取值
	 */
	public void csReq(HttpServletRequest req);
	
	
	

}
