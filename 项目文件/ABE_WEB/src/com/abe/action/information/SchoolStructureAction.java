/**
 * 
 */
package com.abe.action.information;

import java.util.List;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.InfoStudent;
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
	private List<School> schools;
	private List<SchoolGrade> grades;
	private List<SchoolClass> classs;
	
	String result = "schoolStructure"; 
	
	
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
	
	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void clearOptions() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void clearSpace() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String gotoQuery() {
		
		return null;
	}
	@Override
	public String queryOfFenYe() {
		String paId = getRequest().getParameter("paId");//此出获取从页面传过来的区部信息id
		paId="112";//此处作为测试使用，保证有数据
		schools = ser.find("from School where paId=?",new Object[]{paId});
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
		return result;
	}
	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
