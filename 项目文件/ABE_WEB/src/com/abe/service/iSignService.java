package com.abe.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.abe.entity.Users;
import com.abe.entity.app.RespSignIn;
import com.abe.entity.app.RespSignUp;

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
	 * app注册
	 * @param uNum
	 * @param uPass
	 * @param uName
	 * @param uType
	 * @return
	 */
	public RespSignIn signUpFromApp(String uNum,String uPass,String uName,String uType);
	
	/**
	 * 上传头像
	 * @param UId 用户编号
	 * @param photo 图片base64码
	 * @return 封装好的RespSignUp
	 */
	public RespSignUp uploadPhoto(String UId,String photo,String format,String abePath) ;
	
	
	
}
