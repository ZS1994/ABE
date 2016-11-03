package com.abe.service.home;

import javax.servlet.http.HttpServletRequest;

import com.abe.entity.InfoStudent;
import com.abe.entity.app.ReqObject;
import com.abe.entity.app.RespStudent;

public interface iStudentService {
	
	/**张顺<br>
	 * 通过学号查找学生 2016-11-2
	 * @param isNum 学号
	 * @return
	 */
	public InfoStudent get(String isNum);
	
	
	/**
	 * app端添加学生【添加宝贝】
	 * @param req
	 * @return
	 */
	public RespStudent addFromApp(HttpServletRequest req);
	
	
	
	/**
	 * 测试request传过来是否可以取值
	 */
	public void csReq(HttpServletRequest req);
	
}
