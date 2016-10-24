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

import com.abe.service.IService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author 张顺
 *<br>2016年9月2日11:37:48
 *<br>权限拦截器（前拦截器）
 */
public class RoleInterceptor extends AbstractInterceptor{

	
	IService ser;
	HttpServletRequest request;
	HttpServletResponse response;
	Map session;
	String path;
	String reqPamrs;
	Object user;
	private static final String PRO_NAME="/ABE_WEB";
	private Logger logger=Logger.getLogger(RoleInterceptor.class);
	
	
	
	public IService getSer() {
		return ser;
	}
	public void setSer(IService ser) {
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
	 * 权限判断方法
	 * @param arg0
	 * @param r
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	/*
	private String roleControl(ActionInvocation arg0,Role r,String pid) throws Exception {
		List<RolePermission> rps=ser.find("from RolePermission where RId=? and PId=?", new String[]{r.getRId(),pid});
		if(rps.size()>0){
			close();
			return arg0.invoke();
		}else {
			response.sendRedirect("error2.jsp");
			close();
			return null;
		}
	}
	*/
	
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		allInit(arg0);
		//以下是权限控制的核心代码
		if (user==null) {//将登录的url排除在外
			if ((PRO_NAME+"/login!login").equals(path)) {
				close();
				return arg0.invoke();
			}else {
				response.sendRedirect("component/error1.jsp");
				close();
				return null;
			}
		}else{ 
			/*
			Users u=(Users)user;
			Role r=u.getR();
			
			if ((PRO_NAME+"/fbd_asdl!queryOfFenyeAsdl").equals(path)) {//硬件组-ASDL-分页
				return roleControl(arg0, r, "1");
			}else if ((PRO_NAME+"/fbd_asdl!deleteAsdl").equals(path)) {//硬件组-ASDL-删除
				return roleControl(arg0, r, "3");
			}else if ((PRO_NAME+"/fbd_asdl!addAsdl").equals(path)) {//硬件组-ASDL-添加
				return roleControl(arg0, r, "2");
			}else if ((PRO_NAME+"/fbd_asdl!updateAsdl").equals(path)) {//硬件组-ASDL-修改
				return roleControl(arg0, r, "4");
			}
			*/
		}
		close(); 
		return arg0.invoke(); 
	}
	
	private void close() {

	}
}
