package com.abe.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.omg.CORBA.Request;

import com.abe.entity.Users;
import com.abe.entity.app.RespSignIn;
import com.abe.entity.app.RespUpdateUser;
import com.abe.entity.app.RespUploadPhoto;
import com.abe.service.iSignService;
import com.abe.tools.Base64;
import com.abe.tools.Constant;
import com.abe.tools.NameOfDate;

public class SignServiceImpl extends BaseServiceImpl implements iSignService{
	
	private Logger logger=Logger.getLogger(SignServiceImpl.class);
	
	@Override
	public String[] signIn(HttpSession session,String hint,Users user) {
		final String HINT_NO_USER="用户不存在";//用户不存在
		final String HINT_NO_PASS="密码错误";//密码错误
		final String result="index";
		final String result_fail="login";
		
		List list=find("from Users where UNum=?", new Object[]{user.getUNum()});
		Users u=null;
		if (list.size()>0) {
			u=(Users) list.get(0);
		}
		if (u==null) {
			hint=HINT_NO_USER;
			return new String[]{hint,result_fail};
		}else {
			if (!u.getUPass().equals(user.getUPass())) {
				hint=HINT_NO_PASS;
				return new String[]{hint,result_fail};
			}else {
				session.setAttribute("user", u);
				return new String[]{hint,result};
			}
		}
	}
	
	
	@Override
	public RespSignIn signInFromApp(String uNum, String uPass) {
		List list=find("from Users where UNum=?", new Object[]{uNum});
		Users u=null;
		if (list.size()>0) {
			u=(Users) list.get(0);
		}
		RespSignIn respSignIn=new RespSignIn();
		if (u==null) {
			respSignIn.setResult("002");
		}else {
			if (!u.getUPass().equals(uPass)) {
				respSignIn.setResult("003");
			}else {
				respSignIn.setResult("001");
				u.setUPass(null);//去掉密码信息
				respSignIn.setData(u);
			}
		}
		return respSignIn;
	}


	@Override
	public RespUploadPhoto uploadPhoto(String UId, String photo,String format,String abePath) {
		//清空格
		if (UId!=null) {
			UId=UId.trim();
		}
		if (photo!=null) {
			photo=photo.trim();
		}
		if (format!=null) {
			format=format.trim();
		}
		RespUploadPhoto uploadPhoto=null;
		if (UId!=null && !UId.equals("") && 
				photo!=null && !photo.equals("") &&
				format!=null && !format.equals("")) {
			Users user=(Users) get(Users.class, UId);
 			if (user==null) {
 				uploadPhoto=new RespUploadPhoto("003", null);
			}else {
				try {
					abePath=abePath+"\\photo\\"+UId;
					File file =new File(abePath);    
					//如果文件夹不存在则创建    
					if  (!file .exists()  && !file .isDirectory()){       
						logger.debug("不存在");  
						file .mkdir();    
					} else{  
						logger.debug("目录存在");  
					}
					logger.debug(abePath);
					String photoPath=abePath+"\\"+NameOfDate.getFileName()+"."+format;
					String uPhotoPath=Constant.ABE_WEB_URL+"/photo/"+UId+"/"+NameOfDate.getFileName()+"."+format;
					Base64.getFromBASE64byte(photo, photoPath);
					user.setUPhotoPath(uPhotoPath);
					update(user);
					uploadPhoto=new RespUploadPhoto("001", user);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else {
			uploadPhoto=new RespUploadPhoto("002", null);
		}
		return uploadPhoto;
	}
	
	/**
	 * 修改个人资料
	 * @param UNum
	 * @param UName
	 * @param UPass
	 * @param UPhotopath
	 * @param UNote
	 * @param RespUpdateUser 
	 * @return
	 */
	public RespUpdateUser updateUser(String UName,String UPass,String UPhotoPath,String UNote,String UNum) {
		List list=find(" update Users set UName=?,UPass=?,UPhotoPath=?,UNote=? where UNum = ?", new Object[]{UName,UPass,UPhotoPath,UNote,UNum});
		Users user=(Users) get(Users.class, UNum);
		RespUpdateUser updateUser=null;
		user.setUName(UName);
		user.setUPass(UPass);
		user.setUPhotoPath(UPhotoPath);
		user.setUNote(UNote);
		update(user);
		updateUser = new RespUpdateUser(null, user); 
		return updateUser;
	}






}
