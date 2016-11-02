package com.abe.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.abe.entity.Users;
import com.abe.service.iBaseService;


public class TestAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private iBaseService ser;
	private Logger logger=Logger.getLogger(TestAction.class);
	
	
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	
	public String test() {
		getRequest().setAttribute("AAA", "这是AAA");
		logger.debug("---------public String test() {--------");
		return SUCCESS;
	}
	
	public String test2() {
		System.out.println("测试能否查询数据库");
		List<Users> users=ser.find("from Users", null);
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getUNum()+" "+users.get(i).getUPass());
		}
		Users users2=(Users) ser.get(Users.class, "123213141");
		logger.debug(users2.getUName());
		//测试修改
		users2.setUName("测试修改");
		ser.update(users2);
		//测试添加
		
		//测试删除
		return SUCCESS;
	}
	
	/**
	 * 模拟APP以base64传输图片到web
	 * @return
	 */
	public String test3() {
		logger.debug("模拟APP以base64传输图片到web");
		List<Users> users=ser.find("from Users", null);
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getUNum()+" "+users.get(i).getUPass());
		}
		Users users2=(Users) ser.get(Users.class, "qwe");
		logger.debug(users2==null);
		
		return SUCCESS;
	}
	
}
