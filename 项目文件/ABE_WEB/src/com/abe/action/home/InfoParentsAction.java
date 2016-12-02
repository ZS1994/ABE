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
import com.abe.service.home.iStudentService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;
import com.opensymphony.xwork2.util.finder.ClassFinder.Info;


/**
 * 家长档案
 * @author 张顺 2016-12-1
 */
public class InfoParentsAction extends BaseAction implements iBaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private iBaseService ser;
	private String result="parents";
	private List<InfoParents> parents;
	private InfoParents parent;
	private Page page;
	private String id; 
	
	private Logger logger=Logger.getLogger(InfoParentsAction.class);
	

	
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
	public List<InfoParents> getParents() {
		return parents;
	}
	public void setParents(List<InfoParents> parents) {
		this.parents = parents;
	}
	public InfoParents getParent() {
		return parent;
	}
	public void setParent(InfoParents parent) {
		this.parent = parent;
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
		parent.setIpId(NameOfDate.getNum());
		ser.save(parent);
		return gotoQuery();
	}

	@Override
	public void clearOptions() {
		if (page!=null) {
			page=null;
		}
		if (parent!=null) {
			parent=null;
		}
		if (parents!=null) {
			parents=null;
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
			parent=(InfoParents) ser.get(InfoParents.class, id);
			if (parent!=null) {
				ser.delete(parent);
			}
		}
		return gotoQuery();
	}

	@Override
	public String gotoQuery() {
		clearOptions();
		parents=ser.find("from InfoParents order by ipName desc", null);
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
		StringBuffer hql=new StringBuffer("from InfoParents ");
		if (id!=null) {
			hql.append(" where ipId='%"+id+"%' ");
		}
		hql.append("order by ipName desc");
		parents=ser.query(hql.toString(), null, hql.toString(), page);
		return result;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

}
