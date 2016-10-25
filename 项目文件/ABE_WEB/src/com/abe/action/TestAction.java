package com.abe.action;

import java.util.List;

import com.abe.entity.Users;
import com.abe.service.iBaseService;


public class TestAction extends BaseAction{

	private iBaseService ser;
	
	
	
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	
	public String test() {
		getRequest().setAttribute("AAA", "这是AAA");
		return SUCCESS;
	}
	
	public String test2() {
		System.out.println("测试能否查询数据库");
		List<Users> users=ser.find("from Users", null);
		System.out.println(users.toArray().toString());
		return SUCCESS;
	}
}
