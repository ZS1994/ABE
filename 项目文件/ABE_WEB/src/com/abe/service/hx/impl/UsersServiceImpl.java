package com.abe.service.hx.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.log4j.Logger;
import net.sf.json.JSONObject;
import com.abe.service.hx.iHttpClientMutator;
import com.abe.service.hx.iUsersService;
import com.abe.tools.HttpClientHelper;

public class UsersServiceImpl implements iUsersService{

	private Logger log=Logger.getLogger(UsersServiceImpl.class);
	private static final String ADDRESS_SOME=iUsersService.ADDRESS+iUsersService.ORG_NAME+"/"+iUsersService.APP_NAME+"/";
	
	@SuppressWarnings("static-access")
	@Override
	public String getToken(String status) {
		HashMap<String, String> hashMap=new HashMap<String, String>();
		hashMap.put("grant_type", "client_credentials");
		hashMap.put("client_id", "YXA6bT3_gKZGEeako5-7Fr2uYA");
		hashMap.put("client_secret", "YXA6t2dRDJBE4mygBoMMkYLpkpA9yyE");
		JSONObject json=JSONObject.fromObject(hashMap);
		String str=null;
		try {
			str = HttpClientHelper.getInstance().doPost(this.ADDRESS_SOME+"token", json.toString(), null);
		} catch (UnsupportedEncodingException e1) {
			log.error("【getToken】访问环信获取token接口失败");
		}
		if (str!=null) {
			JSONObject jsonObject=JSONObject.fromObject(str);
			if (status!=null) {
				try {
					str=jsonObject.getString(status);
				} catch (Exception e) {
					log.error("【getToken】不存在这个键："+status+"。将返回完整数据。");
					return jsonObject.toString();
				}
			}
		}
		return str;
	}




	@SuppressWarnings("static-access")
	@Override
	public String addUser(String name,String pass,String token) {
		String result=null;
		String url=this.ADDRESS_SOME+"users";
		HashMap<String, String> hashMap=new HashMap<String, String>();
		hashMap.put("username", name);
		hashMap.put("password", pass);
		try {
			result=HttpClientHelper.getInstance().doPost(url, JSONObject.fromObject(hashMap).toString(), token);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			log.error("【addUser】访问环信接口失败");
		}
		return result;
	}
	
	
	
	
	public static void main(String[] args) {
		UsersServiceImpl impl=new UsersServiceImpl();
		String str=impl.getToken(iUsersService.ACCESS_TOKEN);
		System.out.println(str);
//		String str2=impl.addUser("qwer1234", "123456", str);
//		System.out.println(str2);
	}




	@Override
	public String queryUser(String name, String token) {
		// TODO Auto-generated method stub
		return null;
	}





	
	
	
}
