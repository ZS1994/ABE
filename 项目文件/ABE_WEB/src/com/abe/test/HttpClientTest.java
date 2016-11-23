package com.abe.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.abe.tools.HttpClientHelper;

public class HttpClientTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		/*
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("UNum", "qwe"));
		list.add(new BasicNameValuePair("UPass", "123"));
		String str=HttpClientHelper.getInstance().doPost("http://zhangshun-zs1994.oicp.net:15202/ABE_WEB/app/sign!signInFromApp", list);
		System.out.println(str);
		*****测试表单post请求成功******
		*/
		/*
		//获取环信token
		HashMap<String, String> hashMap=new HashMap<String, String>();
		hashMap.put("grant_type", "client_credentials");
		hashMap.put("client_id", "YXA6bT3_gKZGEeako5-7Fr2uYA");
		hashMap.put("client_secret", "YXA6t2dRDJBE4mygBoMMkYLpkpA9yyE");
		JSONObject json=JSONObject.fromObject(hashMap);
		System.out.println(json);
		String str=HttpClientHelper.getInstance().doPost("https://a1.easemob.com/1149161109115389/abeweb/token", json.toString());
		System.out.println(str);
		********测试json参数post请求成功*********
		*/
	}
}
