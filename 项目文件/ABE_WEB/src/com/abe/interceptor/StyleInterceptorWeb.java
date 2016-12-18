package com.abe.interceptor;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import com.abe.service.iBaseService;
import com.abe.tools.Constant;
import com.abe.tools.TokenProccessor;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author 张顺
 *<br>2016-11-14
 *<br>令牌拦截器（前拦截器）
 */
public class StyleInterceptorWeb extends AbstractInterceptor{

	
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
	String actionName;
	String methodName;
	private static final String PRO_NAME="/"+Constant.ABE_WEB_NAME+"/web";
	private Logger logger=Logger.getLogger(StyleInterceptorWeb.class);
	
	
	
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	private void allInit(ActionInvocation arg0) throws UnsupportedEncodingException {
		// 取得请求相关的ActionContext实例  
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
    	//获取其他信息
		ActionContext ctx = arg0.getInvocationContext();  
        session = ctx.getSession();  
        //获得url
        path = request.getRequestURI();//url
        reqPamrs = request.getQueryString();//后面的参数
        //获取登录者信息
        user =session.get("user");
        //获取action的名字
        actionName = arg0.getProxy().getActionName();
        //获取action的方法名字
        methodName = arg0.getProxy().getMethod();
	}
	
	
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		allInit(arg0);
		//以下是令牌控制的核心代码
		if (methodName.equals("queryOfFenYe")) {
			String selInd=request.getParameter("selInd");
			if (selInd!=null) {
				request.getSession().setAttribute("selInd", selInd);
			}
		}
		close(); 
		return arg0.invoke();
	}
	
	private void close() {

	}
    
}
