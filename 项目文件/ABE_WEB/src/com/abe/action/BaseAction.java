package com.abe.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	
	
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
	
	
	
	
	
}
