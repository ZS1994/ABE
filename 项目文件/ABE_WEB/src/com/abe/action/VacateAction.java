package com.abe.action;

import org.apache.log4j.Logger;

import com.abe.service.iBaseService;
import com.abe.service.iVacateService;

public class VacateAction extends BaseAction implements iBaseAction {
	private static final long serialVersionUID = 1L;

	private iBaseService ser;
	private iVacateService vacateSer;
	
	private Logger logger=Logger.getLogger(SignAction.class);
	
	
	public iBaseService getSer() {
		return ser;
	}

	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	public iVacateService getVacateSer() {
		return vacateSer;
	}

	public void setVacateSer(iVacateService vacateSer) {
		this.vacateSer = vacateSer;
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
