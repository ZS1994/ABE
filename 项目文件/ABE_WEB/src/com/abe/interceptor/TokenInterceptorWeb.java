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
public class TokenInterceptorWeb extends AbstractInterceptor{

	
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
	private Logger logger=Logger.getLogger(TokenInterceptorWeb.class);
	
	
	
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
//		logger.debug(method);
		//以下是令牌控制的核心代码
		String result=null;
		if (methodName.equals("gotoQuery") || methodName.equals("queryOfFenYe")){
			String token = TokenProccessor.getInstance().makeToken();//创建令牌
//			logger.info("在TokenInterceptorWeb中生成的token："+token);
			request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		} else {
//			Thread.sleep(3000);//模拟网络延迟
			boolean b = isRepeatSubmit(request);//判断用户是否是重复提交
            if(b==true){
                logger.error("请不要重复提交");
                response.sendRedirect("/"+Constant.ABE_WEB_NAME+"/component/error_token.jsp");
                return null;
            }
        	request.getSession().removeAttribute("token");//移除session中的token
//        	logger.info("处理用户提交请求！！");
        	//-----------------------------------------
        	String token = TokenProccessor.getInstance().makeToken();//创建新令牌
			request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		}
		result=arg0.invoke();
		close(); 
		return result; 
	}
	
	private void close() {

	}
	
	/**
     * 判断客户端提交上来的令牌和服务器端生成的令牌是否一致
     * @param request
     * @return 
     *         true 用户重复提交了表单 
     *         false 用户没有重复提交表单
     */
    private boolean isRepeatSubmit(HttpServletRequest request) {
        String client_token = request.getParameter("token");
        //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
        if(client_token==null){
            return true;
        }
        //取出存储在Session中的token
        String server_token = (String) request.getSession().getAttribute("token");
        //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
        if(server_token==null){
            return true;
        }
        //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
        if(!client_token.equals(server_token)){
            return true;
        }
        return false;
    }
    
    
}
