package com.abe.action.information;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.InfoTeacher;
import com.abe.entity.School;
import com.abe.entity.SchoolClass;
import com.abe.entity.SchoolGrade;
import com.abe.entity.app.RespCommon;
import com.abe.service.iBaseService;
import com.abe.service.hx.iChatgroupService;
import com.abe.service.information.iSchoolClassService;
import com.abe.service.information.iSchoolGradeService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;

/**
 * 张顺 2016-11-8
 * <br>班级管理
 * @author 张顺
 */
public class SchoolClassAction extends BaseAction implements iBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private iBaseService ser;
	private iSchoolClassService classSer;
	private iChatgroupService groupSer;
	private List<SchoolClass> scs;
	private SchoolClass cla;
	private String result="class";
	private Page page;
	String id;
	String cz;
	
	public iChatgroupService getGroupSer() {
		return groupSer;
	}
	public void setGroupSer(iChatgroupService groupSer) {
		this.groupSer = groupSer;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public SchoolClass getCla() {
		return cla;
	}
	public void setCla(SchoolClass cla) {
		this.cla = cla;
	}
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	public iSchoolClassService getClassSer() {
		return classSer;
	}
	public void setClassSer(iSchoolClassService classSer) {
		this.classSer = classSer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<SchoolClass> getScs() {
		return scs;
	}
	public void setScs(List<SchoolClass> scs) {
		this.scs = scs;
	}
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	//---------------------------------------------------
	/**
	 * 张顺 2016-11-8
	 * <br>从APP添加班级
	 * @return
	 * @throws IOException 
	 */
	/*【已删除】app端只能查看,张顺，2016-11-30
	public String addFromApp() throws IOException {
		String scName=ser.clearSpace(getRequest(), "scName");
		String sgId=ser.clearSpace(getRequest(), "sgId");
		String itId=ser.clearSpace(getRequest(), "itId");
		RespCommon schoolClass=new RespCommon();
		if (sgId==null) {
			schoolClass.setResult("003");
			schoolClass.setData(null);
		}else if (scName==null) {
			schoolClass.setResult("004");
			schoolClass.setData(null);
		}else if (itId==null) {
			schoolClass.setResult("006");
			schoolClass.setData(null);
		}else {
			SchoolGrade grade=(SchoolGrade) ser.get(SchoolGrade.class, sgId);
			InfoTeacher teacher=(InfoTeacher) ser.get(InfoTeacher.class, itId);
			if (grade==null) {
				schoolClass.setResult("002");
				schoolClass.setData(null);
			}else if (teacher==null) {
				schoolClass.setResult("005");
				schoolClass.setData(null);
			}else {
				SchoolClass class1=new SchoolClass(NameOfDate.getNum(), scName, sgId, itId);
				ser.save(class1);
				schoolClass.setResult("001");
				schoolClass.setData(null);
			}
		}
		sendToApp(schoolClass, ser);
		return null;
	}		
	*/
	
	@Override
	public String add() {
		clearSpace();
		if (cla!=null) {
			cla.setScId(NameOfDate.getNum());
			cla.setScState("有效");//添加时默认为有效
			cla.setScCreateTime(new Timestamp(new Date().getTime()));//默认创建时间添加
			ser.save(cla);
			groupSer.addChatgroup(cla);
		}
		return gotoQuery();
	}

	@Override
	public void clearOptions() {
		cla=null;
		scs=null;
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
			cla=(SchoolClass) ser.get(SchoolClass.class, id);
			ser.delete(cla);
		}
		return gotoQuery();
	}

	@Override
	public String gotoQuery() {
		clearOptions();
		if (page!=null) {
			page.setPageOn(1);
		}else {
			page=new Page(1, 0, 10);
		}
		String hql="from SchoolClass order by scCreateTime desc";
		scs=ser.query(hql, null, hql, page);
		for(int i = 0 ; i< scs.size(); i++){
			InfoTeacher t = (InfoTeacher) ser.get(InfoTeacher.class,scs.get(i).getItId());
			scs.get(i).setInfoTeacher(t);
			SchoolGrade s=(SchoolGrade) ser.get(SchoolGrade.class, scs.get(i).getSgId()) ;
			scs.get(i).setSchoolGrade(s);
		}
		return result;
	}

	/**
	 * 张顺 2016-11-8
	 * <br>从APP获取班级信息
	 * @return
	 * @throws IOException 
	 */
	public String queryFromApp() throws IOException {
		String scId=ser.clearSpace(getRequest(), "scId");
		RespCommon class1=new RespCommon();
		if (scId==null) {
			class1.setResult("003");
			class1.setData(null);
		}else {
			SchoolClass class2=(SchoolClass) ser.get(SchoolClass.class, scId);
			if (class2==null) {
				class1.setResult("002");
				class1.setData(null);
			}else {
				
				class1.setResult("001");
				class1.setData(class2);
			}
		}
		sendToApp(class1, ser);
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
		StringBuffer hql=new StringBuffer("from SchoolClass where 1=1 ");
		if (id!=null) {
			hql.append("and scId like '%"+id+"%' ");
		}
		hql.append("order by scCreateTime desc");
		scs=ser.query(hql.toString(), null, hql.toString(), page);
		for(int i = 0 ; i< scs.size(); i++){
			InfoTeacher t = (InfoTeacher) ser.get(InfoTeacher.class,scs.get(i).getItId());
			scs.get(i).setInfoTeacher(t);
			SchoolGrade s=(SchoolGrade) ser.get(SchoolGrade.class, scs.get(i).getSgId()) ;
			scs.get(i).setSchoolGrade(s);
		}
		return result;
	}
	
	/**
	 * 张顺 2016-11-8
	 * <br>从APP修改班级信息
	 * @return
	 * @throws IOException 
	 */
	/*【已删除】app端只能查看,张顺，2016-11-30
	public String updateFromApp() throws IOException {
		String scId=ser.clearSpace(getRequest(), "scId");
		String itId=ser.clearSpace(getRequest(), "itId");
		String scName=ser.clearSpace(getRequest(), "scName");
		RespCommon class1=new RespCommon();
		if (itId==null) {
			class1.setResult("006");
			class1.setData(null);
		}else if (scId==null) {
			class1.setResult("003");
			class1.setData(null);
		}else if (scName==null) {
			class1.setResult("004");
			class1.setData(null);
		}else {
			InfoTeacher teacher=(InfoTeacher) ser.get(InfoTeacher.class, itId);
			SchoolClass class2=(SchoolClass) ser.get(SchoolClass.class, scId);
			if (teacher==null) {
				class1.setResult("005");
				class1.setData(null);
			}else if (class2==null) {
				class1.setResult("002");
				class1.setData(null);
			}else {
				class2.setScName(scName);
				class2.setItId(itId);
				ser.update(class2);
				class1.setResult("001");
				class1.setData(null);
			}
		}
		sendToApp(class1, ser);
		return null;
	}	
	*/	
		
	@Override
	public String update() {
		//此处涉及老师表和年级表，暂时不写
//		if(cla!=null && cla.getScId()!=null && !"".equals(cla.getScId().trim())){
//			SchoolClass s = (SchoolClass) ser.get(SchoolClass.class, cla.getScId());
//			cla.setScName(s.getScName());
//		}
//		ser.update(cla);
		clearSpace();
		if (cla!=null) {
			ser.update(cla);
		}
		return result;
	}

}
