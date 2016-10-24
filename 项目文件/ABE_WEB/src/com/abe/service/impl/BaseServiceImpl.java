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
	
	
	
	
	
	public void delete(Object obj) {
		dao.delete(obj);
	}
	public List find(String hql,Object[] ss) {
		return dao.find(hql,ss);
	}
	public List findOfFenYe(String hql, int start, int size) {
		return dao.findOfFenYe(hql, start, size);
	}
	public void save(Object obj) {
		dao.save(obj);
	}
	public void update(Object obj) {
		dao.update(obj);
	}
	public List query(String hql1, Object[] ss, String hql2, Page page,
			iBaseService ser) {
		return null;
	}
	public void timeLine(String state, String tableName, String id) {
		
	}
	public Object get(Class c, Serializable id) {
		return null;
	}
	
	
	
	
}
