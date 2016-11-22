/**
 * 
 */
package com.abe.service.home;

import java.util.List;


public interface iScoreService {

	/**
	 *  2016年11月21日 
	 * <br/>通过家长编号查找自己(多个)孩子的(多门)成绩分数
	 * @author 张顺 
	 * @param UId
	 * @return
	 */
	public List get(String UId);
	
	/**
	 *  2016年11月22日 
	 * <br/>通过学生编号查找成绩分数
	 * @author 张顺 
	 * @param isId
	 * @return
	 */
	public List getOfisId(String isId);
}
