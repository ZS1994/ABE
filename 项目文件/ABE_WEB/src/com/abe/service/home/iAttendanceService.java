/**
 * 
 */
package com.abe.service.home;

import java.util.List;


/**
 * @author 张顺
 *<br/>考勤管理接口
 */
public interface iAttendanceService{
	
	/**
	 * 2016年11月25日
	 * @author 张顺
	 * @param CId
	 * @param clState
	 *<br/>添加一条考勤记录
	 */
	public void add(String CId,String clState);
	
	/**
	 * 2016年11月25日
	 * @author 张顺
	 * @return
	 * <br/>查询所有考勤记录
	 */
	public List queryAll();
	
	/**
	 * 2016年11月25日
	 * @author 张顺
	 * @param CId
	 * @return
	 * <br/>通过卡片id查询该卡片的考勤记录
	 */
	public List queryOfCid(String CId);
	
	/**
	 * 2016年11月25日
	 * @author 张顺
	 * @param UId
	 * @return
	 * <br/>使用UId查询该用户或用户孩子的考勤信息
	 * @适用范围  适用于app对接
	 */
	public List queryOfUid(String UId);
	
	
	/**张顺 2016-12-16
	 * 获取持卡人姓名
	 */
	public String getSrtName(String CId);
	
}
