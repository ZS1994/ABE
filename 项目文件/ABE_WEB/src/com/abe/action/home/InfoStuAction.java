package com.abe.action.home;

import java.io.IOException;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.InfoStudent;
import com.abe.entity.app.ReqObject;
import com.abe.entity.app.RespStudent;
import com.abe.service.iBaseService;
import com.abe.service.home.iStudentService;
import com.abe.tools.NameOfDate;


/**
 * 学生档案
 * @author 张顺 2016-11-1 21:45:12
 */
public class InfoStuAction extends BaseAction implements iBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//service们
	private iBaseService ser;
	private iStudentService studentSer;
	//-------------
	private String result="studentManager";
	private String result_fail="";
	
	private InfoStudent student;
	
	private Logger logger=Logger.getLogger(InfoStuAction.class);
	

	public iStudentService getStudentSer() {
		return studentSer;
	}
	public void setStudentSer(iStudentService studentSer) {
		this.studentSer = studentSer;
	}
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	public InfoStudent getStudent() {
		return student;
	}
	public void setStudent(InfoStudent student) {
		this.student = student;
	}


	/**
	 * 添加宝贝（学生）
	 * @throws IOException 
	 */
	public String addFromApp() throws IOException {
		logger.debug("-------进入addFromApp()---------");
//		studentSer.csReq(getRequest());
		RespStudent respStudent=studentSer.addFromApp(getRequest());
		JSONObject jsonObject=ser.objToJson(respStudent, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
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
