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
	
	/*
	 * 类写在这里，暂时没想到省需要哪些操作，也许一个修改足以
	 * 张顺
	 * 2016-11-6 21:39:18
	 */
	
	
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

	
	/**
	 * 张顺 2016-11-5 22:41:33<br>
	 * 从APP添加省
	 * @return
	 */
	public String addFromApp() {
		/*
		 * 省市固定的，所以没有添加一说，但方法先保留在这
		 */
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

	@Override
	public String queryOfFenYe() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 张顺 2016-11-6 21:47:17<br>
	 * 从APP改省数据
	 * @return
	 */
	public String updateFromApp() {
		/*
		 * 也没什么要改的，就那么几个省，为了改还写个方法？先放着，需要的话以后再写
		 * 张顺
		 * 2016-11-6 22:07:34
		 */
		return null;
	}
	
	@Override
	public String update() {
		
		
		return null;
	}

}
