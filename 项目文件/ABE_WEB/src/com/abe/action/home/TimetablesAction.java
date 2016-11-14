package com.abe.action.home;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.Course;
import com.abe.entity.InfoTeacher;
import com.abe.entity.SchoolClass;
import com.abe.entity.Timetables;
import com.abe.entity.app.RespCommon;
import com.abe.entity.app.RespTimetables;
import com.abe.service.iBaseService;
import com.abe.service.home.iTimetablesService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;

/**
 * 张顺 2016-11-12
 * <br>课程表管理
 * @author 张顺
 */
public class TimetablesAction extends BaseAction implements iBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private iBaseService ser;
	private iTimetablesService timetablesSer;
	private Logger log=Logger.getLogger(TimetablesAction.class);
	
	private Page page;
	private Course course;
	private Timetables timetables;
	private String result="timetablesManager";

	//---------------------------------------------------
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Timetables getTimetables() {
		return timetables;
	}
	public void setTimetables(Timetables timetables) {
		this.timetables = timetables;
	}
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	public iTimetablesService getTimetablesSer() {
		return timetablesSer;
	}
	public void setTimetablesSer(iTimetablesService timetablesSer) {
		this.timetablesSer = timetablesSer;
	}
	//---------------------------------------------------
	
	//张顺 2016-11-13
	@Override
	public String add() {
		System.out.println("--------public String add() {---------");
		//装载Time字段
		String stime=ser.clearSpace(getRequest(), "time1");
		String etime=ser.clearSpace(getRequest(), "time2");
		if (stime!=null) {
			String ss[]=stime.split(":");
			timetables.setTStartTime(new Time(Integer.valueOf(ss[0]), Integer.valueOf(ss[1]), 0));
		}
		if (etime!=null) {
			String ss[]=etime.split(":");
			timetables.setTEndTime(new Time(Integer.valueOf(ss[0]), Integer.valueOf(ss[1]), 0));
		}
		System.out.println(timetables.toString());
		timetables.setTId(NameOfDate.getNum());
		ser.save(timetables);
		return null;
	}

	@Override
	public void clearOptions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearSpace() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String gotoQuery() {
		List<List<Timetables>> list=timetablesSer.getAllOfWeek(new Date());
		getRequest().setAttribute("ttlist", list);
		return result;
	}

	/**
	 * 张顺 2016-11-12
	 * <br>从APP查本周的课程表
	 * @return
	 * @throws IOException 
	 */
	public String queryFromApp() throws IOException {
		/* 1，找到这周的第一天:周顺序：周一、周二。。。周日
		 * 2，循环得到这一周的课程表并保存在封装中
		 * 3，转json，发送
		 */
		RespTimetables timetable=new RespTimetables();
		List<List<Timetables>> list=timetablesSer.getAllOfWeek(new Date());
        timetable.setResult("001");
        timetable.setData(list);
        JSONObject jsonObject=ser.objToJson(timetable, null);
        sendToApp(jsonObject, ser);
		return null;
	}
	
	
	@Override
	public String queryOfFenYe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

}
