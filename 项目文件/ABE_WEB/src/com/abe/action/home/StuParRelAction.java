package com.abe.action.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import org.apache.log4j.Logger;

import sun.security.krb5.internal.PAEncTSEnc;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.Forum;
import com.abe.entity.InfoParents;
import com.abe.entity.InfoStudent;
import com.abe.entity.StudentParentRel;
import com.abe.entity.Users;
import com.abe.entity.app.ReqObject;
import com.abe.entity.app.RespCommon;
import com.abe.entity.app.RespStudent;
import com.abe.service.iBaseService;
import com.abe.service.home.iParentService;
import com.abe.service.home.iRelService;
import com.abe.service.home.iStudentService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;
import com.opensymphony.xwork2.util.finder.ClassFinder.Info;


/**
 * 学生家长关系
 * @author 张顺 2016-12-1
 */
public class StuParRelAction extends BaseAction implements iBaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private iBaseService ser;
	private iStudentService stuSer;
	private iParentService parSer;
	private iRelService relSer;
	private String result="rel";
	private List<StudentParentRel> rels;
	private StudentParentRel rel;
	private Page page;
	private String id; 
	
	private Logger logger=Logger.getLogger(StuParRelAction.class);
	

	
	public iRelService getRelSer() {
		return relSer;
	}
	public void setRelSer(iRelService relSer) {
		this.relSer = relSer;
	}
	public iStudentService getStuSer() {
		return stuSer;
	}
	public void setStuSer(iStudentService stuSer) {
		this.stuSer = stuSer;
	}
	public iParentService getParSer() {
		return parSer;
	}
	public void setParSer(iParentService parSer) {
		this.parSer = parSer;
	}
	public List<StudentParentRel> getRels() {
		return rels;
	}
	public void setRels(List<StudentParentRel> rels) {
		this.rels = rels;
	}
	public StudentParentRel getRel() {
		return rel;
	}
	public void setRel(StudentParentRel rel) {
		this.rel = rel;
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
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	//---------------------------------------------------------
	@Override
	public String add() {
		stuSer.addRel(rel.getIpId(), rel.getIsId(), rel.getSpRelation());
		return gotoQuery();
	}

	@Override
	public void clearOptions() {
		if (page!=null) {
			page=null;
		}
		if (rel!=null) {
			rel=null;
		}
		if (rels!=null) {
			rels=null;
		}
		if (id!=null) {
			id=null;
		}
	}

	@Override
	public void clearSpace() {
		if (id!=null) {
			id=id.trim();
		}
	}

	@Override
	public String delete() {
		String id=ser.clearSpace(getRequest(), "id");
		if (id!=null) {
			rel=(StudentParentRel) ser.get(StudentParentRel.class, id);
			if (rel!=null) {
				ser.delete(rel);
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
		String hql="from StudentParentRel order by ipId";
		rels=ser.query(hql, null,hql,page);
		relSer.initRel(rels);
		getRequest().setAttribute("stus", stuSer.getAllStu());
		getRequest().setAttribute("pars", parSer.getAllParents());
		return result;
	}

	
	@Override
	public String queryOfFenYe() {
		String cz=getRequest().getParameter("cz");
		if (page==null) {
			page=new Page(1, 0, 10);
		}
		if (cz!=null && cz.equals("yes")) {
			clearOptions();
			page=new Page(1, 0, 10);
		}
		clearSpace();
		StringBuffer hql=new StringBuffer("from StudentParentRel ");
		if (id!=null) {
			hql.append(" where spId like'%"+id+"%' ");
		}
		hql.append("order by ipId");
		rels=ser.query(hql.toString(), null, hql.toString(), page);
		relSer.initRel(rels);
		getRequest().setAttribute("stus", stuSer.getAllStu());
		getRequest().setAttribute("pars", parSer.getAllParents());
		return result;
	}

	@Override
	public String update() {
		clearSpace();
		if (rel!=null) {
			ser.update(rel);
		}
		return gotoQuery();
	}

}
