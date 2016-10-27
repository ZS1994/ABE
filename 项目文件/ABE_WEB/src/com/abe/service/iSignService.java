package com.abe.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.abe.entity.Users;
import com.abe.entity.app.RespSignIn;

public interface iSignService {
	
	/**
	 * web登录
	 * @param session
	 * @param hint
	 * @param user
	 * @return
	 */
	public String[] signIn(HttpSession session,String hint,Users user);
	
	/**
	 * app登录
	 * @param uNum
	 * @param uPass
	 * @return
	 */
	public RespSignIn signInFromApp(String uNum,String uPass);
	
	
	
	/**
	 * 注册
	 * @param request request用来取app传送的数据
	 */
	public void signUp(HttpServletRequest request) ;
	
	
	
}
