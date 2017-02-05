package com.abe.action.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import com.abe.entity.other.ReqObject;
import com.abe.entity.other.RespCommon;
import com.abe.entity.other.RespStudent;
import com.abe.service.iBaseService;
import com.abe.service.home.iParentService;
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
	private iParentService parentSer;
	
	private String result="parents";
	private List<InfoParents> parents;
	private InfoParents parent;
	private Page page;
	private String id; 
	private String cz; 
	
	private Logger logger=Logger.getLogger(InfoParentsAction.class);
	

	
	public iParentService getParentSer() {
		return parentSer;
	}
	public void setParentSer(iParentService parentSer) {
		this.parentSer = parentSer;
	}
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
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
	public String addFromApp() {
		String UId=ser.clearSpace(getRequest(), "UId");
		String ipName=ser.clearSpace(getRequest(), "ipName");
		String ipBirthday=ser.clearSpace(getRequest(), "ipBirthday");
		String ipAddress=ser.clearSpace(getRequest(), "ipAddress");
		String ipPhone=ser.clearSpace(getRequest(), "ipPhone");
		String ipSex=ser.clearSpace(getRequest(), "ipSex");
		String CCode=ser.clearSpace(getRequest(), "CCode");
		InfoParents p=new InfoParents(null, ipName, ipSex, ser.toDate(ipBirthday), ipPhone, ipAddress);
		RespCommon resp=parentSer.addFromApp(UId, p, CCode);
		sendToApp(resp, ser);
		return null;
	}
	
	public String queryCode() {
		String UId=ser.clearSpace(getRequest(), "UId");
		String ipPhone=ser.clearSpace(getRequest(), "ipPhone");
		parentSer.saveCode(UId, ipPhone, (int)((Math.random()*9+1)*100000)+"");//发送6位随机数验证码
		RespCommon resp=parentSer.getCode(UId);
		sendToApp(resp, ser);
		return null;
	}
	
	public String queryFromApp() {
		String UId=ser.clearSpace(getRequest(), "UId");
		RespCommon resp=parentSer.queryParent(UId);
		sendToApp(resp, ser);
		return null;
	}
	
	@Override
	public String add() {
		clearSpace();
		if (parent!=null) {
			parent.setIpId(NameOfDate.getNum());
			ser.save(parent);
		}
		return gotoQuery();
	}

	@Override
	public void clearOptions() {
		parent=null;
		parents=null;
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
			parent=(InfoParents) ser.get(InfoParents.class, id);
			if (parent!=null) {
				ser.delete(parent);
			}
		}
		return gotoQuery();
	}

	@Override
	public String gotoQuery() {
		clearSpace();
		clearOptions();
		if (page!=null) {
			page.setPageOn(1);
		}else {
			page=new Page(1, 0, 10);
		}
		String hql="from InfoParents order by ipName desc";
		parents=ser.query(hql, null, hql, page);
		return result;
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
		StringBuffer hql=new StringBuffer("from InfoParents where 1=1");
		if (id!=null) {
			hql.append(" and ipId  like '%"+id+"%' ");
		}
		hql.append("order by ipName desc");
		parents=ser.query(hql.toString(), null, hql.toString(), page);
		return result;
	}

	@Override
	public String update() {
		clearSpace();
		if(parent != null){
			ser.update(parent);
		}
		return gotoQuery();
	}

}
