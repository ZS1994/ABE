package com.abe.interceptor;

import java.io.UnsupportedEncodingException;
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

import com.abe.entity.PowerRole;
import com.abe.entity.PowerRolePermission;
import com.abe.entity.Users;
import com.abe.service.iBaseService;
import com.abe.tools.Constant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author 张顺
 *<br>2016年9月2日11:37:48
 *<br>权限拦截器（前拦截器）
 */
public class RoleInterceptorWeb extends AbstractInterceptor{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ActionInvocation acin;
	iBaseService ser;
	HttpServletRequest request;
	HttpServletResponse response;
	Map session;
	String path;
	String reqPamrs;
	Users user;
	PowerRole role;
	String actionName;
	String methodName;
	private static final String PRO_NAME="/"+Constant.ABE_WEB_NAME+"/web";
	private Logger logger=Logger.getLogger(RoleInterceptorWeb.class);
	
	
	
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	private void allInit(ActionInvocation arg0) throws UnsupportedEncodingException {
		acin=arg0;
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
        user =(Users) session.get("user");
        if (user!=null && user.getRId()!=null) {
        	List<PowerRole> list=ser.find("from PowerRole where RId=?", new String[]{user.getRId()});
			if (list.size()>0) {
				role=list.get(0);
			}
		}
        //获取action的名字
        actionName = arg0.getProxy().getActionName();
        //获取action的方法名字
        methodName = arg0.getProxy().getMethod();
	}
	
	/**
	 * 权限判断方法
	 */
	private String roleControl(String pid) throws Exception {
		if (role!=null) {
			List<PowerRolePermission> rps=ser.find("from PowerRolePermission where RId=? and PId=?", new String[]{role.getRId(),pid});
			if(rps.size()>0){
				close();
				return acin.invoke();
			}else {
				response.sendRedirect("/"+Constant.ABE_WEB_NAME+"/component/error2.jsp");
				close();
				return null;
			}
		}else {
			response.sendRedirect("/"+Constant.ABE_WEB_NAME+"/component/error2.jsp");
			close();
			return null;
		}
	}
	
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		allInit(arg0);
		//以下是权限控制的核心代码
		String result=null;
		if (user==null) {//例外列表
			if (actionName.equals("sign")){
				if (methodName.equals("queryOfFenYe") || methodName.equals("gotoQuery") || methodName.equals("signIn")) {
					result=arg0.invoke();
					return result;
				}else {
					response.sendRedirect("/"+Constant.ABE_WEB_NAME+"/component/error1.jsp");
					result=null;
				}
			}else {
				response.sendRedirect("/"+Constant.ABE_WEB_NAME+"/component/error1.jsp");
				result=null;
			}
		}else{ 
			if (actionName.equals("users")) {//用户管理
				if (methodName.equals("queryOfFenYe") || methodName.equals("gotoQuery")) {
					return roleControl("4");
				}else if (methodName.equals("add")) {
					return roleControl("1");
				}else if (methodName.equals("delete")) {
					return roleControl("2");
				}else if (methodName.equals("update")) {
					return roleControl("3");
				}
			}
			
			/* -----在这里补全----- */
			
		}
		close(); 
		/*这里暂时把没有补全的内容直接让其通行*/
		result=arg0.invoke();
		return result; 
	}
	
	private void close() {

	}
}
