package com.abe.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.abe.entity.InfoTeacher;
import com.abe.entity.PowerRole;
import com.abe.entity.School;
import com.abe.entity.SchoolClass;
import com.abe.entity.SchoolGrade;
import com.abe.entity.SchoolSection;
import com.abe.entity.Timetables;
import com.abe.entity.Users;
import com.abe.service.iBaseService;
import com.abe.tools.JsonDateValueProcessor;
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
	public void sendToApp(Object obj,iBaseService ser) {
		try {
			JSONObject json=null;
			json=ser.objToJson(obj);
			getPrintWriter().print(json);
			getPrintWriter().flush();
			getPrintWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	/**
	 * 张顺 2016-12-13
	 * 发送jsonarray数据
	 * @param obj
	 * @param ser
	 */
	public JSONArray sendJsonArry(Object obj,iBaseService ser) {
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor("yyyy-MM-dd"));
		jsonConfig.registerJsonValueProcessor(Timestamp.class, new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss"));
		jsonConfig.registerJsonValueProcessor(Time.class, new JsonDateValueProcessor("HH:mm:ss"));
		JSONArray array=JSONArray.fromObject(obj,jsonConfig);
		try {
			getPrintWriter().print(array);
			getPrintWriter().flush();
			getPrintWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return array;
	}
	
	/*2017-1-12，张顺，以下方法是用于实现按照班级架构进行权限控制
	 * 用于实现数据访问范围的限制。
	 * */
	public Users getUser(iBaseService ser) {
		Users user=(Users) getSession().getAttribute("user");
		user=initUsers(ser, user);
		return user;
	}
	
	public Users initUsers(iBaseService ser,Users u) {
		if (u!=null && u.getUType().equals("2") && u.getTrpId()!=null) {
			if (u.getRId()!=null) {
				PowerRole role=(PowerRole) ser.get(PowerRole.class, u.getRId());
				u.setRole(role);
			}
			InfoTeacher infoTea=(InfoTeacher) ser.get(InfoTeacher.class, u.getTrpId());
			if (infoTea!=null) {
				//2017-1-12，张顺，获取学校信息并保存,2017-1-13获取班级信息并保存
				/*从三个方面来找教职工的学校：
				 * 		1、如果是班级的班主任，那么该班级所属的学校即是。
				 * 		2、如果是课程表的课程的授课老师，那么该课程所属的课程表，该课程表所属的班级，该班级所属的学校即是。
				 * 		3、如果是部门的一员，那么该部门所属的学校即是。
				 * */
				boolean isFind=false;//是否已经找到的标志
				boolean isFind2=false;//是否已经找到的标志2班级
				School school=null;//先声明,待用
				List<SchoolClass> scs=ser.find("from SchoolClass where itId=?", new String[]{infoTea.getItId()});
				if (isFind==false && scs.size()>0 && scs.get(0).getSgId()!=null && isFind2==false) {
					SchoolGrade sg=(SchoolGrade) ser.get(SchoolGrade.class, scs.get(0).getSgId());
					u.setSc(scs.get(0));
					if (sg!=null && sg.getSId()!=null) {
						school=(School) ser.get(School.class, sg.getSId());
						if (school!=null) 
							isFind=true;
					}
				}
				List<Timetables> tts=ser.find("from Timetables where itId=?", new String[]{infoTea.getItId()});
				if (isFind==false && tts.size()>0 && tts.get(0).getScId()!=null) {
					SchoolClass sc=(SchoolClass) ser.get(SchoolClass.class, tts.get(0).getScId());
					if (sc!=null && sc.getSgId()!=null && isFind2==false) {
						SchoolGrade sg=(SchoolGrade) ser.get(SchoolGrade.class, sc.getSgId());
						u.setSc(sc);
						if (sg!=null && sg.getSId()!=null) {
							school=(School) ser.get(School.class, sg.getSId());
							if (school!=null) 
								isFind=true;
						}
					}
				}
				if (isFind==false && infoTea.getSsId()!=null) {
					SchoolSection sss=(SchoolSection) ser.get(SchoolSection.class, infoTea.getSsId());
					if (sss!=null && sss.getSId()!=null) {
						school=(School) ser.get(School.class, sss.getSId());
						if (school!=null) 
							isFind=true;
					}
				}
				if (school!=null) {
					u.setSchool(school);
					//2017-1-14，张顺，获取并保存用户的角色
					PowerRole role=(PowerRole) ser.get(PowerRole.class, u.getRId());
					u.setRole(role);
					return u;
				}
			}
		}
		return u;
	}
	
	/**张顺，2017-1-13
	 * 组装hql，用户的搜索条件+全局条件+资源访问条件=总的条件=最终的hql
	 * @param hql 用户的所搜条件，原始hql
	 * @return
	 */
	public String initHql(String hql) {
		
		
		return hql;
	}
}
