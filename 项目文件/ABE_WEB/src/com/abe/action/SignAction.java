package com.abe.action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;

import com.abe.entity.Users;
import com.abe.entity.app.RespSignIn;
import com.abe.entity.app.RespSignUp;
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
	 * @throws IOException
	 */
	public String signInFromApp() throws IOException {
		logger.debug("-------进入signInFromApp--------");
		String uNum=(String) getRequest().getParameter("UNum");
		String uPass=(String) getRequest().getParameter("UPass");
		RespSignIn respSignIn=signSer.signInFromApp(uNum, uPass);
		JSONObject jsonObject=ser.objToJson(respSignIn, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
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
	 * APP创建账号
	 * @throws IOException 
	 */
	public String signUpFromApp() throws IOException{
		String uNum=(String) getRequest().getParameter("UNum");
		String uPass=(String) getRequest().getParameter("UPass");
		String uName=(String) getRequest().getParameter("uName");
		String uType=(String) getRequest().getParameter("uType");
		RespSignIn respSignIn=signSer.signUpFromApp(uNum, uPass,uName ,uType);
		JSONObject jsonObject=ser.objToJson(respSignIn, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}

	/**
	 * 上传图片
	 * @return
	 * @throws IOException 
	 */
	public String uploadPhoto() throws IOException {
		String uid=getRequest().getParameter("UId");
		String photo=getRequest().getParameter("UPhoto");
		String format=getRequest().getParameter("format");
		//项目物理路径
		String abePath=getRequest().getRealPath("/");
		RespSignUp respSignUp=signSer.uploadPhoto(uid, photo, format, abePath);
		JSONObject json=ser.objToJson(respSignUp, null);
		getPrintWriter().print(json);
		getPrintWriter().flush();
		getPrintWriter().close();
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
		// TODO Auto-generated method stub
		return null;
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

	