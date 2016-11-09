package com.abe.action.information;

import java.io.IOException;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.InfoTeacher;
import com.abe.entity.School;
import com.abe.entity.SchoolClass;
import com.abe.entity.SchoolGrade;
import com.abe.entity.app.RespCommon;
import com.abe.service.iBaseService;
import com.abe.service.information.iSchoolClassService;
import com.abe.service.information.iSchoolGradeService;
import com.abe.tools.NameOfDate;

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
	/**
	 * 张顺 2016-11-8
	 * <br>从APP添加班级
	 * @return
	 * @throws IOException 
	 */
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 张顺 2016-11-8
	 * <br>从APP修改班级信息
	 * @return
	 * @throws IOException 
	 */
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
		
		
	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

}
