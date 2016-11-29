package com.abe.service.hx.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import com.abe.service.hx.iChatgroupService;
import com.abe.service.hx.iUsersService;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.tools.Constant;
import com.abe.tools.HttpClientHelper;

public class ChatGroupServiceImpl extends BaseServiceImpl implements iChatgroupService{

	iUsersService userSer;
	
	
	
	public iUsersService getUserSer() {
		return userSer;
	}
	public void setUserSer(iUsersService userSer) {
		this.userSer = userSer;
	}

	//------------------------------------------------------
	
	@Override
	public String addUser(String groupid, String username, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addUsers(String groupid, String[] usernames, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("static-access")
	@Override
	public String createChatgroup(String json, String token) {
		try {
			return HttpClientHelper.getInstance().doPost(Constant.ADDRESS_SOME+"chatgroups", json, token);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String deleteChatgroup(String groupid, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String overGroup(String groupid, String newowner, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryChatgroupUsers(String groupid, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryChatgroups(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryChatgroupsInfo(String token, String[] groupids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryGroupOfUser(String username, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeUser(String groupid, String username, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeUsers(String groupid, String[] usernames, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateChatgroup(String groupid, String json, String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
