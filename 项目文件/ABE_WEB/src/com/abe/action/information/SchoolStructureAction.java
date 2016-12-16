/**
 * 
 */
package com.abe.action.information;

import java.util.List;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.InfoStudent;
import com.abe.entity.PlaceArea;
import com.abe.entity.PlaceCity;
import com.abe.entity.PlaceProvince;
import com.abe.entity.School;
import com.abe.entity.SchoolClass;
import com.abe.entity.SchoolGrade;
import com.abe.service.iBaseService;

/**
 * 2016年12月7日
 * @author 张顺
 *<br/>用来展示学校的班级结构及学生
 */
public class SchoolStructureAction  extends BaseAction implements iBaseAction{
	
	private iBaseService ser;
	private PlaceProvince pp;
	private PlaceCity pc;
	private PlaceArea pa;
	private List<School> schools;
	private List<SchoolGrade> grades;
	private List<SchoolClass> classs;
	
	private String result = "schoolStructure"; 
	private String cz=null;
	
	
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	public PlaceProvince getPp() {
		return pp;
	}
	public void setPp(PlaceProvince pp) {
		this.pp = pp;
	}
	public PlaceCity getPc() {
		return pc;
	}
	public void setPc(PlaceCity pc) {
		this.pc = pc;
	}
	public PlaceArea getPa() {
		return pa;
	}
	public void setPa(PlaceArea pa) {
		this.pa = pa;
	}
	public List<School> getSchools() {
		return schools;
	}
	public void setSchools(List<School> schools) {
		this.schools = schools;
	}
	public List<SchoolGrade> getGrades() {
		return grades;
	}
	public void setGrades(List<SchoolGrade> grades) {
		this.grades = grades;
	}
	public List<SchoolClass> getClasss() {
		return classs;
	}
	public void setClasss(List<SchoolClass> classs) {
		this.classs = classs;
	}
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	
	/*
	public String queryAll(){
		schools = ser.find("from School", null);
		for(int i = 0 ; i<schools.size();i++){
			List<SchoolGrade>	g = ser.find("from SchoolGrade where SId =?", new Object[]{schools.get(i).getSId()});
			schools.get(i).setGrade(g);
			for (int j = 0; j < g.size(); j++) {
				List<SchoolClass> c = ser.find("from SchoolClass where sgId", new Object[]{g.get(j).getSgId()});
				schools.get(i).getGrade().get(j).setSclass(c);
				for (int k = 0; k < c.size(); k++) {
					List<InfoStudent> s =ser.find("from InfoStudent where scId=?", new Object[]{c.get(k).getScId()});
					schools.get(i).getGrade().get(j).getSclass().get(i).setStudent(s);
				}
			}
		}
		return result;
	}
	*/
	@Override
	public void clearOptions() {
		cz=null;
	}
	@Override
	public void clearSpace() {
		cz=cz==null?null:cz.trim();
	}
	@Override
	public String add() {
		clearSpace();
		return gotoQuery();
	}
	@Override
	public String delete() {
		clearSpace();
		return gotoQuery();
	}
	@Override
	public String gotoQuery() {
		clearOptions();
		return queryOfFenYe();
	}
	@Override
	public String queryOfFenYe() {
		clearSpace();
		List<PlaceProvince> pps=ser.find("from PlaceProvince", null);
		if (pps.size()>0) {
			pp=pps.get(0);
			List<PlaceCity> pcs=ser.find("from PlaceCity where ppId=?", new String[]{pp.getPpId()});
			if (pcs.size()>0) {
				pc=pcs.get(0);
				List<PlaceArea> pas=ser.find("from PlaceArea where pcId=?", new String[]{pc.getPcId()});
				if (pas.size()>0) {
					pa=pas.get(0);
					schools = ser.find("from School where paId=?",new Object[]{pa.getPaId()});
					for(int i = 0 ; i<schools.size();i++){
						List<SchoolGrade>	g = ser.find("from SchoolGrade where SId =?", new Object[]{schools.get(i).getSId()});
						schools.get(i).setGrade(g);
						for (int j = 0; j < g.size(); j++) {	//只显示有效的班级，
							List<SchoolClass> c = ser.find("from SchoolClass where scState ='有效' and sgId=?", new Object[]{g.get(j).getSgId()});
							schools.get(i).getGrade().get(j).setSclass(c);
							for (int k = 0; k < c.size(); k++) {
								List<InfoStudent> s =ser.find("from InfoStudent where scId=?", new Object[]{c.get(k).getScId()});
								schools.get(i).getGrade().get(j).getSclass().get(i).setStudent(s);
							}
						}
					}
				
				}
			}
		}
		//带上信息
		getRequest().setAttribute("pps", getAny("from PlaceProvince"));
		getRequest().setAttribute("pcs", getAny("from PlaceCity"));
		getRequest().setAttribute("pas", getAny("from PlaceArea"));
		return result;
	}
	@Override
	public String update() {
		clearSpace();
		return gotoQuery();
	}
	
	private List getAny(String hql) {
		try {
			List list=ser.find(hql, null);
			return list;
		} catch (Exception e) {
			return null;
		}
	}
	
}
