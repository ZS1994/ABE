package com.abe.action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;

import com.abe.entity.Users;
import com.abe.entity.other.RespCommon;
import com.abe.entity.other.RespSignIn;
import com.abe.entity.other.RespUpdateUser;
import com.abe.entity.other.RespUploadPhoto;
import com.abe.service.iBaseService;
import com.abe.service.iSignService;
import com.abe.tools.Base64;
import com.abe.tools.Constant;
import com.abe.tools.JsonDateValueProcessor;
import com.abe.tools.NameOfDate;

/**
 * 登录、登出、注册管理acion
 * @author 张顺
 *	2016-10-25 22:59:36
 */
public class SignAction extends BaseAction implements iBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private iBaseService ser;
	private iSignService signSer;
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
	public iSignService getSignSer() {
		return signSer;
	}
	public void setSignSer(iSignService signSer) {
		this.signSer = signSer;
	}
	/**
	 * 登录
	 */
	public String signIn() {
		hint="";
		String str[]=signSer.signIn(getSession(), hint, user);
		hint=str[0];
		logger.debug(hint);
		return str[1];
	}

	/**
	 * APP端登录
	 * @return
	 * @throws Exception 
	 */
	public String signInFromApp() throws Exception {
		logger.debug("-------进入signInFromApp--------");
		String uNum=(String) getRequest().getParameter("UNum");
		String uPass=(String) getRequest().getParameter("UPass");
		RespCommon respSignIn=signSer.signInFromApp(uNum, uPass,getRequest());
		JSONObject jsonObject=ser.objToJson(respSignIn);
//		logger.debug(jsonObject.toString());
		sendToApp(jsonObject);
		return null;
	}
	
	
	/**
	 *登出 
	 */
	public String signOut() {
		
		return null;
	}
	
	/**
	 * 创建账号
	 */
	public String signUp() {
		
		return null;
	}
	
	/**
	 * 张顺 2016-12-21
	 * 获取验证码
	 * @return
	 */
	public String queryCode() {
		String phone=ser.clearSpace(getRequest(), "ipPhone");
		RespCommon resp=signSer.queryCode(phone);
		sendToApp(resp, ser);
		return null;
	}
	
	/**
	 * APP创建账号
	 * @throws IOException 
	 */
	public String signUpFromApp() throws IOException{
		logger.info("-------进入signUpFromApp--------");
		String uNum=ser.clearSpace(getRequest(), "UNum");
		String uPass=ser.clearSpace(getRequest(), "UPass");
		String uName=ser.clearSpace(getRequest(), "UName");
		String ipPhone=ser.clearSpace(getRequest(), "ipPhone");
		String code=ser.clearSpace(getRequest(), "CCode");
		RespSignIn respSignIn=signSer.signUpFromApp(uNum, uPass,uName,ipPhone,code);
		sendToApp(respSignIn, ser);
		return null;
	}
	
	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void clearOptions() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void clearSpace() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String gotoQuery() {
		return result_fail;
	}
	@Override
	public String queryOfFenYe() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

	