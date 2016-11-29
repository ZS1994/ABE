package com.abe.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.abe.service.iBaseService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 基础action类，自己写的action都必须继承他，他有一些常用的基本方法供调用
 * @author 张顺
 */
public class BaseAction extends ActionSupport{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private PrintWriter printWriter;
	private HttpSession session;
	
	
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	public void setRequest(HttpServletRequest request) throws UnsupportedEncodingException {
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setCharacterEncoding("utf-8");
		this.request = req;
	}
	public HttpServletResponse getResponse() {
		HttpServletResponse resp=ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
//		resp.setContentType("text/html;charset=utf-8");
		return resp;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public PrintWriter getPrintWriter() throws IOException {
		PrintWriter pw=getResponse().getWriter();
		return pw;
	}
	public void setPrintWriter(PrintWriter printWriter) {
		this.printWriter = printWriter;
	}
	public HttpSession getSession() {
		return getRequest().getSession();
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	/**
	 * 张顺 2016-11-25
	 * <br>发送json，而且可以适应各种json类型转换的问题
	 * @param obj
	 * @param ser
	 * @throws IOException
	 */
	public void sendToApp(Object obj,iBaseService ser) throws IOException {
		JSONObject json=null;
		json=ser.objToJson(obj);
		getPrintWriter().print(json);
		getPrintWriter().flush();
		getPrintWriter().close();
	}
	
	/**
	 * 张顺 2016-11-12
	 * <br>对之前方法的补充与完善，该方法发送包含date的对象
	 * @param obj
	 * @param ser
	 * @throws IOException
	 */
	@Deprecated
	public void sendToApp2(Object obj,iBaseService ser) throws IOException {
		JSONObject json=null;
		json=ser.objToJson2(obj, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(json);
		getPrintWriter().flush();
		getPrintWriter().close();
	}
	
	/**
	 * 张顺 2016-11-13
	 * <br>对之前方法的完善，由于之前的方法不能对json作单独处理，故写了这个只负责发送的方法，旨在适应各种json的情况
	 * @param json
	 * @param ser
	 * @throws IOException
	 */
	public void sendToApp(JSONObject json) throws IOException {
		getPrintWriter().print(json);
		getPrintWriter().flush();
		getPrintWriter().close();
	}
	
}
