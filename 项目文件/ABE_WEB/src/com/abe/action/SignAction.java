package com.abe.action;

import org.apache.log4j.Logger;

import com.abe.entity.Users;
import com.abe.service.iBaseService;

/**
 * 登录、登出、注册管理acion
 * @author 张顺
 *	2016-10-25 22:59:36
 */
public class SignAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String HINT_NO_USER="用户不存在";//用户不存在
	private static final String HINT_NO_PASS="密码错误";//密码错误

	
	private iBaseService ser;
	private Users user;
	private String result="index";
	private String result_fail="login";
	private String hint;//提示信息
	
	private Logger logger=Logger.getLogger(SignAction.class);
	//----------------------------------
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	
	/**
	 * 登录
	 */
	public String login() {
		hint="";
		logger.debug("---进入signaction--");
		System.out.println("00000000000000000000000000");
		Users u=(Users) ser.get(Users.class, user.getUNum());
		if (u==null) {
			hint=HINT_NO_USER;
			return result_fail;
		}else {
			if (u.getUPass().equals(user.getUPass())) {
				hint=HINT_NO_PASS;
				return result_fail;
			}else {
				getSession().setAttribute("user", u);
				return result;
			}
		}
	}

	/**
	 *登出 
	 */
	public String logout() {
		
		return null;
	}
	
	/**
	 * 注册
	 */
	public String join() {
		
		return null;
	}
	
}

	