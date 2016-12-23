package com.abe.action.information;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.InfoTeacher;
import com.abe.entity.PlaceArea;
import com.abe.entity.School;
import com.abe.entity.SchoolGrade;
import com.abe.entity.other.RespCommon;
import com.abe.service.iBaseService;
import com.abe.service.information.iSchoolService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;

/**
 * 张顺 2016-11-8
 * <br>学校管理
 * @author 张顺
 */
public class SchoolAction extends BaseAction implements iBaseAction{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private iBaseService ser;
	private iSchoolService schoolSer;
	private List<School> schools;
	private School sch;
	private Page page;
	private String result="school";
	private String id;
	private String cz;
	
	
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	public List<School> getSchools() {
		return schools;
	}
	public void setSchools(List<School> schools) {
		this.schools = schools;
	}
	public School getSch() {
		return sch;
	}
	public void setSch(School sch) {
		this.sch = sch;
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
	public iSchoolService getSchoolSer() {
		return schoolSer;
	}
	public void setSchoolSer(iSchoolService schoolSer) {
		this.schoolSer = schoolSer;
	}

	/**
	 * 张顺 2016-11-8
	 * <br>从APP添加学校信息
	 * @return
	 * @throws IOException 
	 */
	public String addFromApp() throws IOException {
		String SName=ser.clearSpace(getRequest(), "SName");
		String SAddress=ser.clearSpace(getRequest(), "SAddress");
		String paId=ser.clearSpace(getRequest(), "paId");
		RespCommon school=new RespCommon();
		if (paId==null) {
			school.setResult("003");
			school.setData(null);
		}else if (SName==null) {
			school.setResult("004");
			school.setData(null);
		}else if (SAddress==null) {
			school.setResult("005");
			school.setData(null);
		}else {
			PlaceArea area=(PlaceArea) ser.get(PlaceArea.class, paId);
			if (area==null) {
				school.setResult("002");
				school.setData(null);
			}else {
				School school2=new School(NameOfDate.getNum(), SName, SAddress, paId);
				ser.save(school2);
				school.setResult("001");
				school.setData(null);
			}
		}
		sendToApp(school, ser);
		return null;
	}
	
	@Override
	public String add() {
		clearSpace();
		if (sch!=null) {
			sch.setSId(NameOfDate.getNum());
			ser.save(sch);
		}
		return gotoQuery();
	}

	@Override
	public void clearOptions() {
		sch=null;
		schools=null;
		id=null;
		cz=null;
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
		clearSpace();
		if (id!=null) {
			sch=(School) ser.get(School.class, id);
			ser.delete(sch);
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
		String hql="from School order by SId desc";
		List<School> ls =ser.query(hql, null, hql, page);
		schools = schoolSer.allFullName(ls);
		return result;
	}

	/**
	 * 张顺 2016-11-8
	 * <br>从APP查看学校信息
	 * @return
	 * @throws IOException 
	 */
	public String queryFromApp() throws IOException {
		String SId=ser.clearSpace(getRequest(), "SId");
		RespCommon school=new RespCommon();
		if (SId==null) {
			school.setResult("003");
			school.setData(null);
		}else {
			School school2=(School) ser.get(School.class, SId);
			if (school2==null) {
				school.setResult("002");
				school.setData(null);
			}else {
				school.setResult("001");
				school.setData(school2);
			}
		}
		sendToApp(school, ser);
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
		StringBuffer hql=new StringBuffer("from School where 1=1 ");
		if (id!=null) {
			hql.append("and SId like '%"+id+"%' ");
		}
		hql.append("order by SId desc");
		List<School> ls=ser.query(hql.toString(), null, hql.toString(), page);
		schools = schoolSer.allFullName(ls);
		for(int i = 0 ; i< schools.size(); i++){
			PlaceArea p = (PlaceArea) ser.get(PlaceArea.class,schools.get(i).getPaId());
			schools.get(i).setPlaceArea(p);
		}
		return result;
	}

	/**
	 * 张顺 2016-11-8
	 * <br>从APP更改学校信息
	 * @return
	 * @throws IOException 
	 */
	public String updateFromApp() throws IOException {
		String SId=ser.clearSpace(getRequest(), "SId");
		String SName=ser.clearSpace(getRequest(), "SName");
		String SAddress=ser.clearSpace(getRequest(), "SAddress");
		RespCommon school=new RespCommon();
		if (SId==null) {
			school.setResult("003");
			school.setData(null);
		}else if (SName==null) {
			school.setResult("004");
			school.setData(null);
		}else if (SAddress==null) {
			school.setResult("005");
			school.setData(null);	
		}else {
			School school2=(School) ser.get(School.class, SId);
			if (school2==null) {
				school.setResult("002");
				school.setData(null);
			}else {
				school2.setSName(SName);
				school2.setSAddress(SAddress);
				ser.update(school2);
				school.setResult("001");
				school.setData(null);
			}
		}
		sendToApp(school, ser);
		return null;
	}
	@Override
	public String update() {
		clearSpace();
		if (sch!=null) {
			ser.update(sch);
		}
		return gotoQuery();
	}

}
