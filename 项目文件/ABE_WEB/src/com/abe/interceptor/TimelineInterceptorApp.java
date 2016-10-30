package com.abe.interceptor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abe.service.iBaseService;
import com.abe.tools.Constant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 时间轴拦截器
 * @author 张顺
 * 2016-10-26 15:23:19
 * <br>后拦截器
 */
public class TimelineInterceptorApp extends AbstractInterceptor{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	iBaseService ser;
	HttpServletRequest request;
	HttpServletResponse response;
	Map session;
	String path;
	String reqPamrs;
	Object user;
	private static final String PRO_NAME="/"+Constant.ABE_WEB_NAME+"/app";
	private Logger logger=Logger.getLogger(TimelineInterceptorApp.class);
	
	
	
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	private void allInit(ActionInvocation arg0) {
		// 取得请求相关的ActionContext实例  
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
    	//获取其他信息
		ActionContext ctx = arg0.getInvocationContext();  
        session = ctx.getSession();  
        //获得url
        path = request.getRequestURI();//url
        reqPamrs = request.getQueryString();//后面的参数
        //获取登录者信息
        user =session.get("user"); 
	}
	
	/**
	 * 保存时间轴
	 * @param u1
	 * @param state
	 * @param tableName
	 * @param tableId
	 * @throws Exception
	 */
	/*
	private void addTimeline(Users u,String state,String tableName,String tableId) throws Exception {
		Timeline tl=new Timeline("tl"+NameOfDate.getNum(), u.getUNum(), new Timestamp(new Date().getTime()), state, tableName, tableId);
		ser.save(tl);
	}
	*/
	
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		String result=arg0.invoke();
		allInit(arg0);
		/*
		//以下是时间轴的核心代码
		if (user==null) {//将登录的url排除在外
			if ((PRO_NAME+"/sign!signIn").equals(path) ||
				(PRO_NAME+"/sign!signInFromApp").equals(path)
				) {
				return arg0.invoke();
			}else {
				response.sendRedirect("component/error1.jsp");
				return null;
			}
		}else{ 
			Users u=(Users)user;
			Role r=u.getR();
			if ((PRO_NAME+"/fbd_asdl!queryOfFenyeAsdl").equals(path)) {//硬件组-ASDL-分页
				addTimeline(u, "查看", "硬件组-ASDL", request.getParameter("id"));
			}else if ((PRO_NAME+"/fbd_asdl!deleteAsdl").equals(path)) {//硬件组-ASDL-删除
				addTimeline(u, "删除", "硬件组-ASDL", request.getParameter("id"));
			}else if ((PRO_NAME+"/fbd_asdl!addAsdl").equals(path)) {//硬件组-ASDL-添加
				FbdAsdl asdl=(FbdAsdl) request.getAttribute("asdl");
				addTimeline(u, "添加", "硬件组-ASDL", asdl.getAsdlId());
			}else if ((PRO_NAME+"/fbd_asdl!updateAsdl").equals(path)) {//硬件组-ASDL-修改
				FbdAsdl asdl=(FbdAsdl) request.getAttribute("asdl");
				addTimeline(u, "修改", "硬件组-ASDL", asdl.getAsdlId());
			}
		}
		close(); 
		 */
		return result; 
	}
	
	private void close() {

	}
}
