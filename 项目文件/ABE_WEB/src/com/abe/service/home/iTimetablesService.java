package com.abe.service.home;

import java.util.Date;
import java.util.List;

import com.abe.entity.Timetables;

public interface iTimetablesService {
	
	/**
	 * 张顺 2016-11-13
	 * <br>得到某一个日期所在周的课程表
	 * @param scId 班级编号
	 * @return
	 */
	public List<List<Timetables>> getAllOfWeek(String scId);
}
