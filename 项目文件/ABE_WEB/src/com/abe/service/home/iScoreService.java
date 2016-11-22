/**
 * 
 */
package com.abe.service.home;

import com.abe.entity.Score;

public interface iScoreService {

	/**
	 *  2016年11月21日 
	 * <br/>通过学生编号查找学生分数
	 * @author 张顺 
	 * @param isId
	 * @return
	 */
	public Score get(String isId);
}
