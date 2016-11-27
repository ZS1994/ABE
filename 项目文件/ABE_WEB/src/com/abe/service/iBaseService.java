package com.abe.service;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;


import com.abe.tools.Page;


/**
 * 公共方法放在这里
 * @author 张顺
 */
public interface iBaseService {
	
	/**
	 * 张顺 
	 * 2016年9月2日11:01:15
	 * 查询所有（可预编译）
	 * @param hql hql语句
	 * @param ss 预编译，ss==null时不采用预编译，ss!=null采用预编译
	 * @return 结果集
	 */
	public List find(String hql,Object[] ss);
	
	/**
	 * 分页查询
	 * @param hql hql语句
	 * @param start 开始位置
	 * @param size 范围
	 * @return list 结果集
	 */
	public List findOfFenYe(String hql,int start,int size);
	
	/**
	 * 查询一个唯一的，通过主键查询
	 * @param c 实体
	 * @param id 主键
	 * @return 一个实体对象
	 */
	public Object get(Class c,Serializable id);
	
	/**
	 * 保存
	 * @param obj 实体
	 */
	public void save(Object obj);
	
	/**
	 * 修改
	 * @param obj 实体
	 */
	public void update(Object obj);
	
	/**
	 * 删除
	 * @param obj 实体
	 */
	public void delete(Object obj);

	/**
	 * 封装完整的分页查询
	 * @param hql1 真正查询的hql语句
	 * @param ss hql1的预编译，为null时不用预编译
	 * @param hql2 查询所有的hql语句
	 * @param page 传一个页码类参数，page用action的，用于给page设置各项属性
	 * @param ser 传一个service类，ser用action的
	 * @return 结果集
	 */
	public List query(String hql1, Object[] ss, String hql2, Page page) ;
	
	/**
	 * 时间轴
	 * @param state 状态：添加、查询、删除、修改（可能有变化，这是暂时的）
	 * @param tableName 操作的表的名字
	 * @param id 操作的表的主键
	 */
	public void timeLine(String state,String tableName,String id);

	
	/**
	 * 按照给定的时间格式进行对象转json
	 * @param obj 需要转的对象（为Timestamp）
	 * @param datePatten 时间格式
	 * @return JSONObject
	 */
	@Deprecated
	public JSONObject objToJson(Object obj,String datePatten);
	
	/**张顺 2016-11-12
	 * 按照给定的时间格式进行对象转json
	 * @param obj 需要转的对象（为Date类型）
	 * @param datePatten 时间格式
	 * @return JSONObject
	 */
	@Deprecated
	public JSONObject objToJson2(Object obj,String datePatten);
	
	/**
	 * 张顺 2016-11-14
	 * <br>object转换成json的封装方法，完美解决时间日期的问题，且可应对各种时间类型
	 * <br>注意：该方法只适合本系统。（因为对数据库的类型有过约定）
	 * @param obj
	 * @return
	 */
	public JSONObject objToJson(Object obj);
	
	
	/**张顺 2016-11-7 22:13:15<br>
	 * 去空格方法，并自带是否为空判断
	 * @param req
	 * @param key
	 * @return
	 */
	public String clearSpace(HttpServletRequest req,String key);
	
	
	public Integer toInteger(String str);
	

	public Date toDate(String str);
	
	
	public Timestamp toTimestamp(String str);
	
	
	public Time toTime(String str);
	
}
