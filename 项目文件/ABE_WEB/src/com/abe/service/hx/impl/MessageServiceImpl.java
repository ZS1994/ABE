package com.abe.service.hx.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.abe.entity.other.ReqMesText;
import com.abe.entity.other.ReqObject;
import com.abe.service.hx.iMessageService;
import com.abe.service.hx.iUsersService;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.tools.Constant;
import com.abe.tools.HttpClientHelper;

public class MessageServiceImpl extends BaseServiceImpl implements iMessageService{

	private Logger log=Logger.getLogger(MessageServiceImpl.class);
	private iUsersService userSer;
	
	
	
	public iUsersService getUserSer() {
		return userSer;
	}
	public void setUserSer(iUsersService userSer) {
		this.userSer = userSer;
	}

	

	@Override
	public String messages(String json, String token) {
		String result=null;
		String url=Constant.ADDRESS_SOME+"messages";
		HashMap<String, String> hashMap=new HashMap<String, String>();
		try {
			result=HttpClientHelper.getInstance().doPost(url, json, token);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			log.error("【messages】访问环信接口失败");
		}
		return result;
	}

	
	
	public String sengMsgOne(String tageusername,String ownusername,String msg) {
		//设置消息体
		ReqMesText mesText=new ReqMesText();
		mesText.setTarget_type("users");
		List<String> list=new ArrayList<String>();
		list.add(tageusername);
		mesText.setTarget(list);
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("type", "txt");
		map.put("msg", msg);
		mesText.setMsg(map);
		mesText.setFrom(ownusername);
		JSONObject json=JSONObject.fromObject(mesText);
		//获取token
		String token=userSer.getToken();
		//发送消息体
		return messages(json.toString(), token);
	}
	
	
	
}
