package com.abe.action.information;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.abe.entity.other.UiTree;
import com.abe.service.iBaseService;

/**
 * 2016年12月7日
 * @author 张顺
 *<br/>用来展示学校的班级结构及学生
 */
public class SchoolStructureAction  extends BaseAction implements iBaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private iBaseService ser;
	private PlaceProvince pp;
	private List<PlaceProvince> pps;
	private PlaceCity pc;
	private PlaceArea pa;
	private List<School> schools;
	private List<SchoolGrade> grades;
	private List<SchoolClass> classs;
	
	private String result = "schoolStructure"; 
	private String cz=null;
	private String id;
	
	
	public List<PlaceProvince> getPps() {
		return pps;
	}
	public void setPps(List<PlaceProvince> pps) {
		this.pps = pps;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	
	
	
	@Override
	public void clearOptions() {
		cz=null;
		id=null;
		pp=null;
		pps=null;
		pc=null;
		pa=null;
		schools=null;
		grades=null;
		classs=null;
	}
	@Override
	public void clearSpace() {
		cz=cz==null?null:cz.trim();
		id=id==null?null:id.trim();
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
		if (cz!=null && cz.equals("yes")) {
			clearOptions();
		}
		pps=ser.find("from PlaceProvince", null);
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
	
	//以下是ajax访问方法
	public String queryPc() {
		clearSpace();
		String ppId=ser.clearSpace(getRequest(), "ppId");
		if (ppId!=null) {
			List<PlaceCity> list=ser.find("from PlaceCity where ppId=?", new String[]{ppId});
			sendJsonArry(list, ser);
		}
		return null;
	}
	public String queryPa() {
		clearSpace();
		String pcId=ser.clearSpace(getRequest(), "pcId");
		if (pcId!=null) {
			List<PlaceArea> list=ser.find("from PlaceArea where pcId=?", new String[]{pcId});
			sendJsonArry(list, ser);
		}
		return null;
	}
	public String querySch() {
		clearSpace();
		List<UiTree> list=new ArrayList<UiTree>();
		String paId=ser.clearSpace(getRequest(), "paId");
		if (id==null) {
			if (paId!=null && !paId.equals("")) {
				schools = ser.find("from School where paId=?",new Object[]{paId});
				for(int i = 0 ; i<schools.size();i++){
					HashMap<String, String> map=new HashMap<String, String>();
					map.put("path", "/web/school!queryOfFenYe?cz=no&id="+schools.get(i).getSId());
					UiTree tr=new UiTree("school,"+schools.get(i).getSId(), schools.get(i).getSName(),null, "closed", false, map, null);
					list.add(tr);
				}
			}
		}else {
			String[] ss=id.split(",");
			if (ss.length>0) {
				if (ss[0].equals("school")) {
					List<SchoolGrade> g = ser.find("from SchoolGrade where SId =?", new Object[]{ss[1]});
					for (int j = 0; j < g.size(); j++) {	//只显示有效的班级，
						HashMap<String, String> map=new HashMap<String, String>();
						map.put("path", "/web/grade!queryOfFenYe?cz=no&id="+g.get(j).getSgId());
						UiTree tr=new UiTree("grade,"+g.get(j).getSgId(), g.get(j).getSgName(),null, "closed", false, map, null);
						list.add(tr);
					}
				}else if (ss[0].equals("grade")) {
					List<SchoolClass> c = ser.find("from SchoolClass where scState ='有效' and sgId=?", new Object[]{ss[1]});
					for (int k = 0; k < c.size(); k++) {
						HashMap<String, String> map=new HashMap<String, String>();
						map.put("path", "/web/class!queryOfFenYe?cz=no&id="+c.get(k).getScId());
						UiTree tr=new UiTree("class,"+c.get(k).getScId(), c.get(k).getScName(),null, "closed", false, map, null);
						list.add(tr);
					}
				}else if (ss[0].equals("class")) {
					List<InfoStudent> s =ser.find("from InfoStudent where scId=?", new Object[]{ss[1]});
					for (int h = 0; h < s.size(); h++) {
						HashMap<String, String> map=new HashMap<String, String>();
						map.put("path", "/web/student!queryOfFenYe?cz=no&id="+s.get(h).getIsId());
						UiTree tr=new UiTree("student"+s.get(h).getIsId(), s.get(h).getIsName(),null, "open", false, map, null);
						list.add(tr);
					}
				}else {
					
				}
			}
		}
		sendJsonArry(list, ser);
		clearOptions();
		return null;
	}
}
