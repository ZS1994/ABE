package com.abe.action.home;

import java.util.List;
import org.apache.log4j.Logger;
import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.Course;
import com.abe.service.iBaseService;
import com.abe.service.home.iCourseService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;

/**
 * 张顺 2016-11-13
 * <br>科目管理
 * @author 张顺
 */
public class CourseAction extends BaseAction implements iBaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger log=Logger.getLogger(CourseAction.class);
	private iBaseService ser;
	private iCourseService courseSer;
	private String result="courseManager";
	private Page page;
	private Course course;
	private List<Course> courses; 

	//--------------------------------------------------
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
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
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	public iCourseService getCourseSer() {
		return courseSer;
	}
	public void setCourseSer(iCourseService courseSer) {
		this.courseSer = courseSer;
	}
	//--------------------------------------------------
	
	
	@Override
	public String add() {
		if (course!=null && !course.getCName().trim().equals("")) {
			course.setCId(NameOfDate.getNum());
			ser.save(course);
			getRequest().setAttribute("course", course);//给时间轴拦截器传值
		}
		return gotoQuery();
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
		courses=courseSer.queryAll();
		return result;
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
