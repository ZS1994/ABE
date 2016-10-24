package com.abe.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseDaoOfSpring implements IBaseDaoOfSpring{
	
	HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	
	//待预编译的多条件查询
	public List find(String hql,Object[] ss) {
		if (ss==null) {
			return ht.find(hql);
		}
		return ht.find(hql, ss);
	}
	
	//分页查询
	public List findOfFenYe(final String hql,final int start,final int size) {
	    List list = getHt().executeFind(
			new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(hql);
					query.setFirstResult(start);
					query.setMaxResults(size);
					List list = query.list();
					return list;
	            }
			}
       );
	   return list;
	}
	
	public Object get(Class c,Serializable id) {
		return ht.get(c,id);
	}
	
	public void save(Object obj) {
		ht.save(obj);
	}
	
	public void update(Object obj) {
		ht.update(obj);
	}
	
	public void delete(Object obj) {
		ht.delete(obj);
	}
	
	
}
