package com.abe.service;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.abe.entity.Users;
import com.abe.entity.app.RespCommon;
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
	@Deprecated
	public RespSignIn signInFromApp(String uNum,String uPass);
	
	/**张顺 2016-11-18
	 * 新版app登录，加入安全访问、权限控制
	 * @param uNum
	 * @param uPass
	 * @return
	 */
	public RespCommon signInFromApp(String uNum,String uPass,HttpServletRequest request)throws Exception;
	
	/**
	 * 张顺 2016-11-18
	 * <br>得到失效时间
	 * @return
	 */
	public Date getEndDate(Date date) ;
	
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
	public RespUploadPhoto uploadPhoto(String UId,String photo,String format,String abePath) ;
	
	/**
	 * app端修改个人信息，密码
	 * @param User
	 */
	public RespUpdateUser updateUser1(String UNum);
	public RespUpdateUser updateUser2(String UName,String UPass,String UType,Timestamp UCreateTime,
			String UPhotoPath,String UNote,String UNum,String UId,String trpId);
	/**
	 *  app查询个人信息资料
	 *  卢江林
	 *  2016.11.27
	 */
	public RespUpdateUser queryUsers(String UId);
	
}
