package com.abe.action.home;

import org.apache.log4j.Logger;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.service.iBaseService;
import com.abe.service.home.iTimetablesService;

/**
 * 张顺 2016-11-12
 * <br>课程表管理
 * @author 张顺
 */
public class TimetablesAction extends BaseAction implements iBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private iBaseService ser;
	private iTimetablesService timetablesSer;
	private Logger log=Logger.getLogger(TimetablesAction.class);
	

	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	public iTimetablesService getTimetablesSer() {
		return timetablesSer;
	}
	public void setTimetablesSer(iTimetablesService timetablesSer) {
		this.timetablesSer = timetablesSer;
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
	 * 张顺 2016-11-12
	 * <br>从APP查本周的课程表
	 * @return
	 */
	public String queryFromApp() {
		
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
