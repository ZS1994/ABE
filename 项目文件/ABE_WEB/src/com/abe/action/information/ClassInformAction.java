package com.abe.action.information;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.ClassInform;
import com.abe.service.iBaseService;
import com.abe.service.information.iClassInformService;

public class ClassInformAction extends BaseAction implements iBaseAction {
	private static final long serialVersionUID = 1L;

	private iBaseService ser;
	private iClassInformService classInformSer;
	private ClassInform classInform;
	public iBaseService getSer() {
		return ser;
	}

	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	public iClassInformService getClassInformSer() {
		return classInformSer;
	}

	public void setClassInformSer(iClassInformService classInformSer) {
		this.classInformSer = classInformSer;
	}

	public ClassInform getClassInform() {
		return classInform;
	}

	public void setClassInform(ClassInform classInform) {
		this.classInform = classInform;
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

	@Override
	public String queryOfFenYe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

}
