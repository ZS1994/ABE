package com.abe.action.information;

import java.io.IOException;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.School;
import com.abe.entity.SchoolGrade;
import com.abe.entity.app.RespCommon;
import com.abe.service.iBaseService;
import com.abe.service.information.iSchoolGradeService;
import com.abe.tools.NameOfDate;

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
	private iBaseService ser;
	private iSchoolGradeService gradeSer;
	
	
	
	
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
		// TODO Auto-generated method stub
		return null;
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
