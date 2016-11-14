package com.abe.service.home.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.abe.entity.Course;
import com.abe.entity.InfoTeacher;
import com.abe.entity.SchoolClass;
import com.abe.entity.Timetables;
import com.abe.entity.app.RespCommon;
import com.abe.service.home.iTimetablesService;
import com.abe.service.impl.BaseServiceImpl;

public class TimetablesServiceImpl extends BaseServiceImpl implements iTimetablesService{

	@Override
	public List<List<Timetables>> getAllOfWeek(Date tagedate) {
		/* 1，找到这周的第一天:周顺序：周一、周二。。。周日
		 * 2，循环得到这一周的课程表并保存在封装中
		 */
		List<List<Timetables>> list=new ArrayList<List<Timetables>>();
		Calendar cal = Calendar.getInstance();
		Date date=null;
		if (tagedate==null) {
			date=new Date();
		}else {
			date=tagedate;
		}
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK)-1;
		if (w<=0) {
			w=7;
		}
//        System.out.println(w);
        //得到一个星期的第一天：周一
        cal.add(Calendar.DATE, 1-w);
        //循环装配一周数据
        for (int i = 0; i < 7; i++) {
			Date date2=cal.getTime();
			date2.setHours(0);
			date2.setMinutes(0);
			date2.setSeconds(0);
//			System.out.println(date2.toLocaleString());
			List<Timetables> timetables=find("from Timetables where TDate=?", new Date[]{date2});
			/*
			 */
			for (int j = 0; j < timetables.size(); j++) {
				//装配关联项
				Course course=(Course) get(Course.class, timetables.get(j).getCId());
				SchoolClass schoolClass=(SchoolClass) get(SchoolClass.class, timetables.get(j).getScId());
				InfoTeacher infoTeacher=(InfoTeacher) get(InfoTeacher.class, timetables.get(j).getItId());
				timetables.get(j).setCourse(course);
				timetables.get(j).setSchoolClass(schoolClass);
				timetables.get(j).setInfoTeacher(infoTeacher);
				//-------------
//				timetables.get(j).setTDate(null);
				/**
				 *张顺 2016-11-13
				 *这里的Time类型在转换时有问题，现在想到的有以下方案：
				 *1，Time改成DateTime
				 *2，换json框架
				 *3，寻求本框架解决的办法
				 */
				timetables.get(j).setTStartTime(null);
				timetables.get(j).setTEndTime(null);
//				System.out.println(timetables.get(j).toString());
			}
			list.add(timetables);
			cal.add(Calendar.DATE, 1);
		}
        System.out.println(list);
		return list;
	}

}
