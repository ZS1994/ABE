package com.abe.action.home;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.PersonInform;
import com.abe.service.iBaseService;
import com.abe.service.home.iPersonInformService;

public class PersonInformAction extends BaseAction implements iBaseAction {
	private static final long serialVersionUID = 1L;

	private iBaseService ser;
	private iPersonInformService personInformSer;
	private PersonInform personInform;
	
	public iBaseService getSer() {
		return ser;
	}

	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	public iPersonInformService getPersonInformSer() {
		return personInformSer;
	}

	public void setPersonInformSer(iPersonInformService personInformSer) {
		this.personInformSer = personInformSer;
	}

	public PersonInform getPersonInform() {
		return personInform;
	}

	public void setPersonInform(PersonInform personInform) {
		this.personInform = personInform;
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
