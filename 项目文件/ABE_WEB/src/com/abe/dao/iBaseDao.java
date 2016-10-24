package com.abe.dao;

import java.io.Serializable;
import java.util.List;

public interface iBaseDao {
	
	public List find(String hql,Object[] ss);
	
	//分页查询
	public List findOfFenYe(String hql,int start,int size);
	
	public Object get(Class c,Serializable id);
	
	public void save(Object obj);
	
	public void update(Object obj);
	
	public void delete(Object obj);
	
}
