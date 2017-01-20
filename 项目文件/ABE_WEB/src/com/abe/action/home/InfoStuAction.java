package com.abe.action.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.InfoParents;
import com.abe.entity.InfoStudent;
import com.abe.entity.StudentParentRel;
import com.abe.entity.Users;
import com.abe.entity.other.RespCommon;
import com.abe.entity.other.RespStudent;
import com.abe.service.iBaseService;
import com.abe.service.home.iStudentService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;


/**
 * 学生档案
 * @author 张顺 2016-11-1 21:45:12
 */
public class InfoStuAction extends BaseAction implements iBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//service们
	private iBaseService ser;
	private iStudentService studentSer;
	//-------------
	private String result="student";
	private InfoStudent student;
	private List<InfoStudent> stus;
	private Page page;
	private String id;
	private String cz;
	
	private Logger logger=Logger.getLogger(InfoStuAction.class);
	
	
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	public iStudentService getStudentSer() {
		return studentSer;
	}
	public void setStudentSer(iStudentService studentSer) {
		this.studentSer = studentSer;
	}
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	public InfoStudent getStudent() {
		return student;
	}
	public void setStudent(InfoStudent student) {
		this.student = student;
	}
	public List<InfoStudent> getStus() {
		return stus;
	}
	public void setStus(List<InfoStudent> stus) {
		this.stus = stus;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 添加宝贝（学生）
	 * @throws IOException 
	 */
	public String addFromApp() throws IOException {
		logger.debug("-------进入addFromApp()---------");
		RespStudent respStudent=studentSer.addFromApp(getRequest());
		sendToApp(respStudent, ser);
		return null;
	}
	@Override
	public String add() {
		logger.debug("-------进入后台添加学生---------");
		clearSpace();
		if(student!=null){
			student.setIsId(NameOfDate.getNum());
			ser.save(student);
		}
		return gotoQuery();
	}

	@Override
	public void clearOptions() {
		stus=null;
		student=null;
		id=null;
		cz=null;
	}

	@Override
	public void clearSpace() {
		if (id!=null) {
			id=id.trim();
		}
		if (cz!=null) {
			cz=cz.trim();
		}
	}

	@Override
	public String delete() {
		clearSpace();
		if (id!=null) {
			student=(InfoStudent) ser.get(InfoStudent.class, id);
			if (student!=null) {
				ser.delete(student);
			}
		}
		return gotoQuery();
	}

	@Override
	public String gotoQuery() {
		clearOptions();
		if (page==null) {
			page=new Page(1, 0, 10);
		}else {
			page.setPageOn(1);
		}
		String hql="from InfoStudent order by isNum desc";
		stus=ser.query(hql, null, hql, page);
		studentSer.initStu(stus);//装填封装
		//带上需要的信息过去
		getRequest().setAttribute("scals", studentSer.getScals());
		return result;
	}

	/**
	 * 张顺 2016-11-12
	 * <br>从APP获取学生信息,通过学生id获取
	 * @return
	 * @throws IOException 
	 */
	public String queryFromApp() throws IOException {
		String isId=ser.clearSpace(getRequest(), "isId");
		RespCommon respStudent=new RespCommon();
		if (isId==null) {
			respStudent.setResult("003");
			respStudent.setData(null);
		}else {
			InfoStudent student=studentSer.getFromId(isId);
			if (student==null) {
				respStudent.setResult("002");
				respStudent.setData(null);
			}else {
				respStudent.setResult("001");
				respStudent.setData(student);
			}
		} 
		sendToApp(respStudent, ser);
		return null;
	}
	
	/**
	 * 张顺 2016-11-18
	 * app通过uid查学生信息
	 * @return
	 * @throws IOException
	 */
	public String queryFromApp2() throws IOException {
		String uid=ser.clearSpace(getRequest(), "UId");
		RespCommon respStudent=new RespCommon();
		if (uid==null) {
			respStudent.setResult("003");
			respStudent.setData(null);
		}else {
			Users user=(Users) ser.get(Users.class, uid);
			if (user==null) {
				respStudent.setResult("002");
				respStudent.setData(null);
			}else if (user.getUType().equals("1")) {
				if (user.getTrpId()!=null) {
					InfoParents parent=(InfoParents) ser.get(InfoParents.class, user.getTrpId());
					if (parent!=null) {
						List<StudentParentRel> rels=ser.find("from StudentParentRel where ipId=?", new String[]{parent.getIpId()});
						List<InfoStudent> list=new ArrayList<InfoStudent>();
						for (int i = 0; i < rels.size(); i++) {
							InfoStudent student=studentSer.getFromId(rels.get(i).getIsId());
							list.add(student);
						}
						respStudent.setResult("001");
						respStudent.setData(list);
					}else {
						respStudent.setResult("2001");
						respStudent.setData(null);
					}
				}else {
					respStudent.setResult("2001");
					respStudent.setData(null);
				}
			}else {
				respStudent.setResult("004");
				respStudent.setData(null);
			}
		} 
		JSONObject json=ser.objToJson(respStudent);
		sendToApp(json, ser);
		return null;
	}
	
	
	/**张顺 2016-11-29
	 * 分页查询所有学生
	 * @return
	 */
	public String queryOfFenYeFromApp() {
		RespCommon respstu=new RespCommon();
		int pageNo=ser.toInteger(ser.clearSpace(getRequest(), "pageNo"));
		int size=ser.toInteger(ser.clearSpace(getRequest(), "size"));
		if (pageNo<=0) {
			respstu.setResult("002");
		}else if (size<=0) {
			respstu.setResult("003");
		}else {
			Page page=new Page(pageNo, 0, size);
			String hql="from InfoStudent";
			List<InfoStudent> students=ser.query(hql, null, hql, page);
			respstu.setResult("001");
			respstu.setData(students);
		}
		sendToApp(respstu, ser);
		return null;
	}
	
	@Override
	public String queryOfFenYe() {
		clearSpace();
		if (cz!=null && cz.equals("yes")) {
			clearOptions();
		}
		if (page==null) {
			page=new Page(1, 0, 10);
		}
		StringBuffer hql=new StringBuffer("from InfoStudent where 1=1 ");
		if (id!=null) {
			hql.append("and isId like '%"+id+"%' ");
		}
		hql.append("order by isNum desc");
		stus=ser.query(hql.toString(), null, hql.toString(), page);
		studentSer.initStu(stus);//装填封装
		//带上需要的信息过去
		getRequest().setAttribute("scals", studentSer.getScals());
		return result;
	}

	@Override
	public String update() {
		clearSpace();
		if (student!=null) {
//			InfoStudent stutmp=(InfoStudent) ser.get(InfoStudent.class, student.getIsId());
//			student.setIsIntoDate(stutmp.getIsIntoDate());
//			student.setIsNum(stutmp.getIsNum());
			ser.update(student);
		}
		return gotoQuery();
	}

}
