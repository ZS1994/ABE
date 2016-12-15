package com.abe.action.home;

import java.util.List;
import org.apache.log4j.Logger;
import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.Course;
import com.abe.entity.Users;
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
	private String id;
	private String cz;
	private Course course;
	private List<Course> courses; 

	//--------------------------------------------------
	public List<Course> getCourses() {
		return courses;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
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
		clearSpace();
		if (course!=null && !course.getCName().trim().equals("")) {
			course.setCId(NameOfDate.getNum());
			ser.save(course);
			getRequest().setAttribute("course", course);//给时间轴拦截器传值
		}
		return gotoQuery();
	}

	@Override
	public void clearOptions() {
		cz=null;
		id=null;
		course=null;
		courses=null;
	}

	@Override
	public void clearSpace() {
		cz=cz!=null?cz.trim():null;
		id=id!=null?id.trim():null;
	}

	@Override
	public String delete() {
		clearSpace();
		if (id!=null) {
			course=(Course) ser.get(Course.class, id);
			if (course!=null) {
				ser.delete(course);
			}
		}
		return gotoQuery();
	}

	@Override
	public String gotoQuery() {
		clearOptions();
		if (page!=null) {
			page.setPageOn(1);
		}else {
			page=new Page(1, 0, 10);
		}
		String hql="from Course";
		courses=ser.query(hql, null, hql, page);
		return result;
	}

	@Override
	public String queryOfFenYe() {
		clearSpace();
		if (cz!=null && cz.equals("yes")) {
			clearOptions();
		}
		if (page==null) {
			page=new Page(1, 0, 10);
		}
		StringBuffer hql=new StringBuffer("from Course where 1=1 ");
		if (id!=null) {
			hql.append("and CId like '%"+id+"%'" );
		}
		hql.append("");
		courses=ser.query(hql.toString(), null, hql.toString(), page);
		return result;
	}

	@Override
	public String update() {
		clearSpace();
		if (course!=null) {
			ser.update(course);
		}
		return gotoQuery();
	}
	
}
