package com.abe.action;

/**
 * 基本action的接口，自己写的action都必须实现它，该接口定义了几乎每个action都要用的方法，如果不用也没关系，放在那就行
 * @author 张顺
 *
 */
public interface iBaseAction {
	/**
	 * 添加数据
	 * @return
	 */
	public String add();
	
	/**
	 * 删除数据
	 * @return
	 */
	public String delete();
	
	/**
	 * 分页条件查询查询，条件为空即查询所有
	 * @return
	 */
	public String queryOfFenYe();
	
	/**
	 * 即不带条件的默认分页查询，且分页为第一页，该方法可在添加、删除、修改、或者刚进主界面时调用
	 * @return
	 */
	public String gotoQuery();
	
	/**
	 * 修改数据
	 * @return
	 */
	public String update();
	
	/**
	 * 用来清楚各项属性，比如查询的条件，页码等等，一般在刚进主界面时调用一次
	 * @return
	 */
	public void clearOptions();
	
	/**
	 * 清除各项属性的空格，防止以后输入的数据不小心带了空格，一般在要使用数据之前调用下
	 */
	public void clearSpace();
	
}
