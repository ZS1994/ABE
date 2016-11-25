package com.abe.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.abe.entity.Licence;
import com.abe.entity.Users;
import com.abe.entity.app.RespCommon;
import com.abe.entity.app.RespSignIn;
import com.abe.entity.app.RespUpdateUser;
import com.abe.entity.app.RespUploadPhoto;
import com.abe.service.iSignService;
import com.abe.service.hx.iUsersService;
import com.abe.tools.Base64;
import com.abe.tools.Constant;
import com.abe.tools.MachineCode;
import com.abe.tools.NameOfDate;
import com.abe.tools.TokenProccessor;

public class SignServiceImpl extends BaseServiceImpl implements iSignService{
	
	private Logger logger=Logger.getLogger(SignServiceImpl.class);
	private iUsersService usersSer;
	
	
	public iUsersService getUsersSer() {
		return usersSer;
	}
	public void setUsersSer(iUsersService usersSer) {
		this.usersSer = usersSer;
	}


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
	@Deprecated
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
	public RespCommon signInFromApp(String uNum, String uPass,
			HttpServletRequest request) throws Exception {
		List list=find("from Users where UNum=?", new Object[]{uNum});
		Users u=null;
		if (list.size()>0) {
			u=(Users) list.get(0);
		}
		RespCommon respSignIn=new RespCommon();
		if (u==null) {
			respSignIn.setResult("002");
		}else {
			if (!u.getUPass().equals(uPass)) {
				respSignIn.setResult("003");
			}else {
				respSignIn.setResult("001");
				u.setUPass(null);//去掉密码信息
				String ip=MachineCode.getIpAddr(request);
				String licence=TokenProccessor.getInstance().makeToken();
				Date dateStart=new Date();
				Date dateEnd=getEndDate(dateStart);
				Licence licencetmp=(Licence) get(Licence.class, u.getUId());
				if (licencetmp==null) {
					Licence licenceObj=new Licence(u.getUId(),licence,ip, new Timestamp(dateStart.getTime()), new Timestamp(dateEnd.getTime()));
					save(licenceObj);
				}else {
					licencetmp.setLLicence(licence);
					licencetmp.setLIp(ip);
					licencetmp.setLDateStart(new Timestamp(dateStart.getTime()));
					licencetmp.setLDateEnd(new Timestamp(dateEnd.getTime()));
					update(licencetmp);
				}
				HashMap map=new HashMap();
				map.put("user", u);
				map.put("licence", licence);
				respSignIn.setData(map);
			}
		}
		return respSignIn;
	}

	
	public Date getEndDate(Date date) {
		Date datetmp=null;
		if (date==null) {
			datetmp=new Date();
		}else {
			datetmp=date;
		}
		Calendar calendar=new GregorianCalendar(); 
		calendar.setTime(datetmp);
		calendar.add(Calendar.HOUR, 1);
		return calendar.getTime();
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
	 * 李钊 注册
	 * @param uNum
	 * @param uPass
	 * @param uName
	 * @param uType
	 * @return
	 */
	@Override
	public RespSignIn signUpFromApp(String uNum, String uPass, String uName,
			String uType) {
		final String HINT_EXISTS_USER = "002";//用户名已存在
		final String HINT_SUCCESS_USER = "001";//注册成功
		RespSignIn respSignIn = new RespSignIn();
		Timestamp time = new Timestamp(new Date().getTime());
		Users users = new Users();
		NameOfDate nameOfData = new NameOfDate();
		List list=find("from Users where UNum=?", new Object[]{uNum});
		if(list.size()>0){
			respSignIn.setResult(HINT_EXISTS_USER);
		}else {
			users.setUCreateTime(time);
			users.setUName(uName);
			users.setUNum(uNum);
			users.setUPass(uPass);
			users.setUType(uType);
			//users.setUType("1");
			users.setUId(nameOfData.getNum());
			save(users);
			respSignIn.setResult(HINT_SUCCESS_USER);
			respSignIn.setData(users);
			//在环信系统中注册
			String token=usersSer.getToken(iUsersService.ACCESS_TOKEN);
			usersSer.addUser(users.getUId(), users.getUPass(), token);
		}
		return respSignIn;
	}
	/**
	 * 修改个人资料
	 * 卢江林
	 * @param UNum
	 * @param UName
	 * @param UPass
	 * @param UPhotopath
	 * @param UNote
	 * @param RespUpdateUser 
	 * @return
	 */
	public RespUpdateUser updateUser1(String UNum) {
		//List list=find(" update Users set UName=?,UPass=?,UPhotoPath=?,UNote=? where UNum =?", new Object[]{UName,UPass,UPhotoPath,UNote,UNum});
		List list=find(" from Users where UNum =?", new Object[]{UNum});
		Users u = new Users();
		RespUpdateUser updateUser= new RespUpdateUser();
		if (list.size()>0) {
			u=(Users) list.get(0);
		
		updateUser.setData(u);
		updateUser.setResult("001");
		}else{
			updateUser.setResult("002");
		}
		return updateUser;
	}
	
	public RespUpdateUser updateUser2(String UName,String UPass,String UType,Timestamp UCreateTime,
			String UPhotoPath,String UNote,String UNum,String UId,String trpId){
		Users u = new Users();
		RespUpdateUser updateUser=null;
		u.setUName(UName);
		u.setUPass(UPass);
		u.setUPhotoPath(UPhotoPath);
		u.setUNote(UNote);
		u.setUType(UType);
		u.setUCreateTime(UCreateTime);
		u.setTrpId(trpId);
		u.setUNum(UNum);
		u.setUId(UId);
		update(u);
		updateUser = new RespUpdateUser(null, u); 
		updateUser.setData(u);
		updateUser.setResult("001");
		return updateUser;
	}


	



}
