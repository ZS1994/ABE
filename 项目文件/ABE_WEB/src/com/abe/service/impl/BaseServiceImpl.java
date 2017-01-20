package com.abe.service.impl;


import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import com.abe.dao.iBaseDao;
import com.abe.service.iBaseService;
import com.abe.tools.JsonDateValueProcessor;
import com.abe.tools.Page;

import freemarker.template.SimpleDate;


/**
 * 公共方法放在这里
 * @author 张顺
 */
public class BaseServiceImpl implements iBaseService{

	iBaseDao dao;
	private Logger log=Logger.getLogger(BaseServiceImpl.class);
	
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
		if (ss!=null) {
			//张顺，2017-1-14，把null换成空字符串以避免sql执行失败
			for (int i = 0; i < ss.length; i++) {
				ss[i]=ss[i]==null?"":ss[i];
			}
		}
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
	
	@Override
	public JSONObject objToJson2(Object obj, String datePatten) {
		JSONObject object=null;
		if (datePatten==null) {
			object=JSONObject.fromObject(obj);
		}else {
			JsonConfig jsonConfig=new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor(datePatten));
			object=JSONObject.fromObject(obj,jsonConfig);
		}
		return object;
	}
	
	@Override
	public JSONObject objToJson(Object obj) {
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor("yyyy-MM-dd"));
		jsonConfig.registerJsonValueProcessor(Timestamp.class, new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss"));
		jsonConfig.registerJsonValueProcessor(Time.class, new JsonDateValueProcessor("HH:mm:ss"));
		JSONObject object=JSONObject.fromObject(obj,jsonConfig);
		return object;
	}
	
	@Override
	public String clearSpace(HttpServletRequest req, String key) {
		String str=req.getParameter(key);
		return str==null?null:str.trim();
	}
	
	
	@Override
	public Date toDate(String str) {
		if (str==null) {
			return null;
		}else {
			try {
				Date date=new SimpleDateFormat("yyyy-MM-dd").parse(str);
				return date;
			} catch (Exception e) {
				log.error("String转Date错误，被转换的String："+str);
				return null; 
			}
		}
	}
	
	@Override
	public Integer toInteger(String str) {
		if (str==null) {
			return null;
		}else {
			try {
				Integer i=Integer.valueOf(str);
				return i;
			} catch (Exception e) {
				log.error("String转Integer错误，被转换的String："+str);
				return null; 
			}
		}
	}
	@Override
	public Time toTime(String str) {
		if (str==null) {
			return null;
		}else {
			try {
				Time time=Time.valueOf(str);
				return time;
			} catch (Exception e) {
				log.error("String转Time错误，被转换的String："+str);
				return null; 
			}
		}
	}
	@Override
	public Timestamp toTimestamp(String str) {
		if (str==null) {
			return null;
		}else {
			try {
				Timestamp timestamp=Timestamp.valueOf(str);
				return timestamp;
			} catch (Exception e) {
				log.error("String转Timestamp错误，被转换的String："+str);
				return null; 
			}
		}
	}
	
	
	
	
}
