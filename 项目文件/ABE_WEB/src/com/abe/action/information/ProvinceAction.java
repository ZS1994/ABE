package com.abe.action.information;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.service.iBaseService;
import com.abe.service.information.iProvinceService;

/**
 * 张顺 2016-11-4<br>
 * 组织架构——省管理
 * @author 张顺
 */
public class ProvinceAction extends BaseAction implements iBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private iBaseService ser;
	private iProvinceService provinceSer;
	
	
	
	
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	public iProvinceService getProvinceSer() {
		return provinceSer;
	}
	public void setProvinceSer(iProvinceService provinceSer) {
		this.provinceSer = provinceSer;
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
