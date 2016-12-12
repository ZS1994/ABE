package com.abe.service.home.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.abe.entity.Course;
import com.abe.entity.InfoTeacher;
import com.abe.entity.SchoolClass;
import com.abe.entity.Timetables;
import com.abe.service.home.iTimetablesService;
import com.abe.service.impl.BaseServiceImpl;

public class TimetablesServiceImpl extends BaseServiceImpl implements iTimetablesService{

	@Override
	public List<List<Timetables>> getAllOfWeek(String scId) {
		List<List<Timetables>> list=new ArrayList<List<Timetables>>();
        for (int i = 0; i < 7; i++) {
			List<Timetables> timetables=find("from Timetables where TWeek=? and scId=?", new Object[]{i+1,scId});
			for (int j = 0; j < timetables.size(); j++) {
				//装配关联项
				Course course=(Course) get(Course.class, timetables.get(j).getCId());
				SchoolClass schoolClass=(SchoolClass) get(SchoolClass.class, timetables.get(j).getScId());
				InfoTeacher infoTeacher=(InfoTeacher) get(InfoTeacher.class, timetables.get(j).getItId());
				timetables.get(j).setCourse(course);
				timetables.get(j).setSchoolClass(schoolClass);
				timetables.get(j).setInfoTeacher(infoTeacher);
				//-------------
				/**
				timetables.get(j).setTDate(null);
				 *张顺 2016-11-13
				 *这里的Time类型在转换时有问题，现在想到的有以下方案：
				 *1，Time改成DateTime
				 *2，换json框架
				 *3，寻求本框架解决的办法
//				timetables.get(j).setTStartTime(null);
//				timetables.get(j).setTEndTime(null);
//				System.out.println(timetables.get(j).toString());
 * 				张顺  2016-11-14   已解决：使用JsonConfig给Time做一个格式转换即可。
				 */
			}
			list.add(timetables);
		}
		return list;
	}

	
	@Override
	public List getDateOfWeek(String scId, int index) {
		List<Timetables> timetables=null;
		if (scId!=null && index>=1 && index<=7) {
			timetables=find("from Timetables where TWeek=? and scId=?", new Object[]{index,scId});
			for (int j = 0; j < timetables.size(); j++) {
				//装配关联项
				Course course=(Course) get(Course.class, timetables.get(j).getCId());
				SchoolClass schoolClass=(SchoolClass) get(SchoolClass.class, timetables.get(j).getScId());
				InfoTeacher infoTeacher=(InfoTeacher) get(InfoTeacher.class, timetables.get(j).getItId());
				timetables.get(j).setCourse(course);
				timetables.get(j).setSchoolClass(schoolClass);
				timetables.get(j).setInfoTeacher(infoTeacher);
			}
		}
		return timetables;
	}

}
