package com.abe.action.information;

import java.io.IOException;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.PlaceArea;
import com.abe.entity.School;
import com.abe.entity.app.RespCommon;
import com.abe.service.iBaseService;
import com.abe.service.information.iSchoolService;
import com.abe.tools.NameOfDate;

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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
