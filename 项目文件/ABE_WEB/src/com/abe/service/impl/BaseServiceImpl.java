package com.abe.service.impl;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.abe.dao.iBaseDao;
import com.abe.service.iBaseService;
import com.abe.tools.JsonDateValueProcessor;
import com.abe.tools.Page;


/**
 * 公共方法放在这里
 * @author 张顺
 */
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
	
	@Override
	public JSONObject objToJson(Object obj, String datePatten) {
		JSONObject object=null;
		if (datePatten==null) {
			object=JSONObject.fromObject(obj);
		}else {
			JsonConfig jsonConfig=new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Timestamp.class, new JsonDateValueProcessor(datePatten));
			object=JSONObject.fromObject(obj,jsonConfig);
		}
		return object;
	}
	
	
	
	
	
	
}
