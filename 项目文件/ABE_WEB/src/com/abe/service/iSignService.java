package com.abe.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.abe.entity.Users;
import com.abe.entity.app.RespSignIn;
import com.abe.entity.app.RespUpdateUser;
import com.abe.entity.app.RespUploadPhoto;

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
	 * 上传头像
	 * @param UId 用户编号
	 * @param photo 图片base64码
	 * @return 封装好的RespSignUp
	 */
	public RespUploadPhoto uploadPhoto(String UId,String photo,String format,String abePath) ;
	
	/**
	 * app端修改个人信息，密码
	 * @param User
	 */
	public RespUpdateUser updateUser1(String UNum);
	public RespUpdateUser updateUser2(String UName,String UPass,String UPhotoPath,String UNote,String UNum,String UId);
}
