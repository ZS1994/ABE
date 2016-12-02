package com.abe.action.information;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.AllInform;
import com.abe.service.iBaseService;
import com.abe.service.information.iBulletinService;

public class BulletinAction extends BaseAction implements iBaseAction {
	private static final long serialVersionUID = 1L;

	private iBaseService ser;
	private iBulletinService bulletinSer;
	private AllInform allInform;
	public iBaseService getSer() {
		return ser;
	}

	public void setSer(iBaseService ser) {
		this.ser = ser;
	}


	public iBulletinService getBulletinSer() {
		return bulletinSer;
	}

	public void setBulletinSer(iBulletinService bulletinSer) {
		this.bulletinSer = bulletinSer;
	}

	public AllInform getAllInform() {
		return allInform;
	}

	public void setAllInform(AllInform allInform) {
		this.allInform = allInform;
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
