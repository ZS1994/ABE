package com.abe.service.home;

import java.util.Date;
import java.util.List;

import com.abe.entity.Timetables;

public interface iTimetablesService {
	
	/**
	 * 张顺 2016-11-13
	 * <br>得到一个班级的课程表
	 * @param scId 班级编号
	 * @return
	 */
	public List<List<Timetables>> getAllOfWeek(String scId);
	
	/**
	 * 张顺 2016-12-12 21:40:40
	 * 得到某一个班级某一天的课程表
	 * @param scId
	 * @param index
	 * @return
	 */
	public List getDateOfWeek(String scId,int index);
	
	
}
