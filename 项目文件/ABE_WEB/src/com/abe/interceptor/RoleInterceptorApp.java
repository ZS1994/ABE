package com.abe.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import com.abe.entity.Licence;
import com.abe.entity.app.RespCommon;
import com.abe.service.iBaseService;
import com.abe.service.iSignService;
import com.abe.tools.Constant;
import com.abe.tools.MachineCode;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author 张顺
 *<br>2016年9月2日11:37:48
 *<br>权限拦截器（前拦截器）
 */
public class RoleInterceptorApp extends AbstractInterceptor{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	iBaseService ser;
	iSignService signSer;
	HttpServletRequest request;
	HttpServletResponse response;
	PrintWriter pw;
	Map session;
	String path;
	String reqPamrs;
	Object user;
	private static final String PRO_NAME="/"+Constant.ABE_WEB_NAME+"/app";
	private Logger logger=Logger.getLogger(RoleInterceptorApp.class);
	
	
	
	public iSignService getSignSer() {
		return signSer;
	}
	public void setSignSer(iSignService signSer) {
		this.signSer = signSer;
	}
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	private void allInit(ActionInvocation arg0) throws IOException {
		// 取得请求相关的ActionContext实例  
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		pw=response.getWriter();
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
		String result=null;
		//声明一个返回封装备用
		RespCommon respc=new RespCommon();
		//登录、注册除外
		if ( (PRO_NAME+"/sign!signInFromApp").equals(path) || (PRO_NAME+"/sign!signUpFromApp").equals(path)) {
			result=arg0.invoke();
		}else {
			String licence=request.getParameter("licence");//数字执照id
			Licence licenceObj=getLicence(licence);//得到数字执照详细信息
			if (licenceObj==null) {//如果为空，即该执照不存在
				respc.setResult("1000");
				respc.setData(null);
				sendJson(respc);
				return null;
			}else {
				if (new Date().after(licenceObj.getLDateEnd())) {//执照过期
					respc.setResult("1001");
					respc.setData(null);
					sendJson(respc);
					return null;
				}else if(!MachineCode.getIpAddr(request).equals(licenceObj.getLIp())){//ip变动
					respc.setResult("1002");
					respc.setData(null);
					sendJson(respc);
					return null;
				}else {
					//执照验证通过
					logger.info("执照验证通过:"+licence);
					checkLicenceDate(licenceObj);
					
					
					result=arg0.invoke();
				}
			}
		}
		close(); 
		return result;
	}
	
	private void close() {

	}
	
	/**
     * 张顺 2016-11-14
     * 得到方法名
     * @return
     */
    public String getMethod(String path) {
    	String ss[]=path.split("!");
    	return ss[ss.length-1];
	}
    
    /**
     * 通过证书得到证书这个对象
     * @param licence
     * @return
     */
    public Licence getLicence(String licence) {
		List<Licence> list=ser.find("from Licence where LLicence=?", new String[]{licence});
		if (list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}
    
    public void sendJson(Object obj) throws IOException {
    	JSONObject json=ser.objToJson(obj);
    	response.getWriter().print(json);
		response.getWriter().flush();
		response.getWriter().close();
	}
    
    /**
     * 张顺 2016-11-18
     * <br>检查执照，每次操作就更新最后失效时间
     * @param licence
     */
    public void checkLicenceDate(Licence licence) {
    	if (licence!=null) {
    		licence.setLDateEnd(new Timestamp(signSer.getEndDate(null).getTime()));
    		ser.update(licence);
		}
	}
}
