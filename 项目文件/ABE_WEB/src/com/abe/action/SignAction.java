package com.abe.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;

import com.abe.entity.Users;
import com.abe.entity.app.RespSignIn;
import com.abe.service.iBaseService;
import com.abe.tools.JsonDateValueProcessor;

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
	public String signIn() {
		hint="";
		List list=ser.find("from Users where UNum=?", new Object[]{user.getUNum()});
		Users u=null;
		if (list.size()>0) {
			u=(Users) list.get(0);
		}
		if (u==null) {
			hint=HINT_NO_USER;
			return result_fail;
		}else {
			if (!u.getUPass().equals(user.getUPass())) {
				hint=HINT_NO_PASS;
				return result_fail;
			}else {
				getSession().setAttribute("user", u);
				return result;
			}
		}
	}

	
	public String signInFromApp() throws IOException {
		logger.debug("-------进入signInFromApp--------");
		String uNum=(String) getRequest().getParameter("UNum");
		String uPass=(String) getRequest().getParameter("UPass");
		List list=ser.find("from Users where UNum=?", new Object[]{uNum});
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
	
}

	