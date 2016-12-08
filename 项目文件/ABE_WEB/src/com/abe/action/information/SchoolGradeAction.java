package com.abe.action.information;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.InfoTeacher;
import com.abe.entity.School;
import com.abe.entity.SchoolGrade;
import com.abe.entity.app.RespCommon;
import com.abe.service.iBaseService;
import com.abe.service.hx.iChatgroupService;
import com.abe.service.information.iSchoolGradeService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;

/**
 * 张顺 2016-11-8
 * <br>年级管理
 * @author 张顺
 */
public class SchoolGradeAction extends BaseAction implements iBaseAction{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private iChatgroupService groupSer;
	private iBaseService ser;
	private iSchoolGradeService gradeSer;
	private SchoolGrade g;
	private List<SchoolGrade> sgs;
	private Page page;
	String cz;
	String id;
	String result = "grade";
	
	
	public iChatgroupService getGroupSer() {
		return groupSer;
	}
	public void setGroupSer(iChatgroupService groupSer) {
		this.groupSer = groupSer;
	}
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	public iSchoolGradeService getGradeSer() {
		return gradeSer;
	}
	public void setGradeSer(iSchoolGradeService gradeSer) {
		this.gradeSer = gradeSer;
	}
	public SchoolGrade getG() {
		return g;
	}
	public void setG(SchoolGrade g) {
		this.g = g;
	}
	public List<SchoolGrade> getSgs() {
		return sgs;
	}
	public void setSgs(List<SchoolGrade> sgs) {
		this.sgs = sgs;
	}
	/**
	 * 张顺 2016-11-8
	 * <br>从APP添加年级
	 * @return
	 * @throws IOException 
	 */
	public String addFromApp() throws IOException {
		String sgName=ser.clearSpace(getRequest(), "sgName");
		String SId=ser.clearSpace(getRequest(), "SId");
		RespCommon grade=new RespCommon();
		if (SId==null) {
			grade.setResult("003");
			grade.setData(null);
		}else if (sgName==null) {
			grade.setResult("004");
			grade.setData(null);
		}else {
			School school=(School) ser.get(School.class, SId);
			if (school==null) {
				grade.setResult("002");
				grade.setData(null);
			}else {
				SchoolGrade grade2=new SchoolGrade(NameOfDate.getNum(), sgName, SId);
				ser.save(grade2);
				grade.setResult("001");
				grade.setData(null);
			}
		}
		sendToApp(grade, ser);
		return null;
	}		
	
	@Override
	public String add() {
		g.setSgId(NameOfDate.getNum());
		ser.save(g);
		clearOptions();
		return gotoQuery();
	}

	@Override
	public void clearOptions() {
		g=null;
		sgs=null;
		id=null;
		cz=null;
		page=null;
	}

	@Override
	public void clearSpace() {
		if(id!=null){
			id=id.trim();
		}
		if(cz!=null){
			cz=cz.trim();
		}
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String gotoQuery() {
		clearOptions();
		String hql="from SchoolGrade order by sgId desc";
		String ss[]={};
		String hql2="from SchoolGrade order by sgId desc";
		sgs=ser.query(hql, ss, hql2, page);
		return result;
	}

	/**
	 * 张顺 2016-11-8
	 * <br>从APP获取年级信息
	 * @return
	 * @throws IOException 
	 */
	public String queryFromApp() throws IOException {
		String sgId=ser.clearSpace(getRequest(), "sgId");
		RespCommon grade=new RespCommon();
		if (sgId==null) {
			grade.setResult("003");
			grade.setData(null);
		}else {
			SchoolGrade grade2=(SchoolGrade) ser.get(SchoolGrade.class, sgId);
			if (grade2==null) {
				grade.setResult("002");
				grade.setData(null);
			}else {
				
				grade.setResult("001");
				grade.setData(grade2);
			}
		}
		sendToApp(grade, ser);
		return null;
	}
	
	@Override
	public String queryOfFenYe() {
		clearSpace();
		if (cz!=null && cz.equals("yes")) {
			clearOptions();
			page=new Page(1, 0, 10);
		}
		if (page==null) {
			page=new Page(1, 0, 10);
		}
		StringBuffer hql=new StringBuffer("from SchoolGrade ");
		if (id!=null) {
			hql.append(" where sgId like '%"+id+"%' ");
		}
		hql.append("order by sgId desc");
		sgs=ser.query(hql.toString(), null, hql.toString(), page);
		for(int i = 0 ; i< sgs.size(); i++){
			School s = (School) ser.get(School.class,sgs.get(i).getSId());
			sgs.get(i).setSchool(s);
		}
		return result;
	}
	
	/**
	 * 张顺 2016-11-8
	 * <br>从APP修改年级信息
	 * @return
	 * @throws IOException 
	 */
	public String updateFromApp() throws IOException {
		String sgId=ser.clearSpace(getRequest(), "sgId");
		String sgName=ser.clearSpace(getRequest(), "sgName");
		RespCommon grade=new RespCommon();
		if (sgId==null) {
			grade.setResult("003");
			grade.setData(null);
		}else if (sgName==null) {
			grade.setResult("004");
			grade.setData(null);
		}else {
			SchoolGrade grade2=(SchoolGrade) ser.get(SchoolGrade.class, sgId);
			if (grade2==null) {
				grade.setResult("002");
				grade.setData(null);
			}else {
				grade2.setSgName(sgName);
				ser.update(grade2);
				grade.setResult("001");
				grade.setData(null);
			}
		}
		sendToApp(grade, ser);
		return null;
	}	
		
		
	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

}
