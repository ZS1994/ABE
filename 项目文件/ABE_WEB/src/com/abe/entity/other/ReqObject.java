package com.abe.entity.other;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * 2016-11-2
 * 用于接收app传过来的数据，一个封装类,封装了一些通用的方法
 * @author 张顺
 *
 */
@Deprecated
public class ReqObject {

	private HashMap<String,String> strs;
	private HttpServletRequest request;
	
	private Logger logger=Logger.getLogger(ReqObject.class);
	
	public HashMap<String, String> getStrs() {
		return strs;
	}
	public void setStrs(HashMap<String, String> strs) {
		this.strs = strs;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
	public ReqObject(HttpServletRequest request) {
		this.strs = new HashMap<String, String>();
		this.request=request;
	}
	
	
	/**
	 * 主要是为了封装去空格的代码
	 * @param key
	 */
	public void add(String key) {
		String value=getRequest().getParameter(key);
		if (value!=null) {
			value=value.trim();
		}
		strs.put(key, value);
	}
	
	//-------以下方法是取各种类型数据的方法-------------
	public String getToString(String key) {
		String str=null; 
		try {
			String string=strs.get(key);
			str=string;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return str;
	}
	public Integer getToInteger(String key) {
		Integer i=null; 
		try {
			String string=strs.get(key);
			if (string!=null) {
				i=Integer.valueOf(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return i;
	}
	public Timestamp getToTimestamp(String key) {
		Timestamp i=null; 
		try {
			String string=strs.get(key);
			if (string!=null) {
				Date date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(string);
				i=new Timestamp(date.getTime());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return i;
	}
	public Date getToDate(String key) {
		Date i=null; 
		try {
			String string=strs.get(key);
			if (string!=null) {
				i=new SimpleDateFormat("yyyy-MM-dd").parse(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return i;
	}
	
	
}
