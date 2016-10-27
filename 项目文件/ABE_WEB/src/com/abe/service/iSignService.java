package com.abe.service;

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
}
