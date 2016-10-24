package com.abe.service;

import java.io.Serializable;
import java.util.List;


import com.abe.tools.Page;



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
	public List query(String hql1,Object ss[],String hql2,Page page,iBaseService ser);
	
	/**
	 * 时间轴
	 * @param state 状态：添加、查询、删除、修改（可能有变化，这是暂时的）
	 * @param tableName 操作的表的名字
	 * @param id 操作的表的主键
	 */
	public void timeLine(String state,String tableName,String id);

	
	
		
	
}
