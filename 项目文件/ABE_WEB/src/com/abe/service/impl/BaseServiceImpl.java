package com.abe.service.impl;


import java.io.Serializable;
import java.util.List;
import com.abe.dao.iBaseDao;
import com.abe.service.iBaseService;
import com.abe.tools.Page;



public class BaseServiceImpl implements iBaseService{

	iBaseDao dao;
	
	//-----------------------
	public iBaseDao getDao() {
		return dao;
	}
	public void setDao(iBaseDao dao) {
		this.dao = dao;
	}
	//------------------------------
	
	
	
	
	public Object get(Class c, Serializable id) {
		return dao.get(c, id);
	}
	public List find(String hql,Object[] ss) {
		return dao.find(hql,ss);
	}
	public void delete(Object obj) {
		dao.delete(obj);
	}
	public void save(Object obj) {
		dao.save(obj);
	}
	
	
	public List findOfFenYe(String hql, int start, int size) {
		return dao.findOfFenYe(hql, start, size);
	}
	
	public void update(Object obj) {
		dao.update(obj);
	}
	
	public List query(String hql1, Object[] ss, String hql2, Page page) {
		if (page==null) {
			page=new Page(1, 0, 5);
		}
		List list=this.find(hql1,ss);
		if (0==list.size()%page.getSize()) {
			page.setPageMax(list.size()/page.getSize());
		}else {
			page.setPageMax(list.size()/page.getSize()+1);
		}
		List list2=this.findOfFenYe(hql2, (page.getPageOn()-1)*page.getSize(), page.getSize());
		return list2;
	}
	
	public void timeLine(String state, String tableName, String id) {
		
	}
	
	
	
	
}
