package com.abe.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.abe.entity.Users;
import com.abe.entity.app.RespSignIn;
import com.abe.service.iSignService;

public class SignServiceImpl extends BaseServiceImpl implements iSignService{
	
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
	public void signUp(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}



}
