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
import com.abe.entity.other.RespCommon;
import com.abe.entity.other.RespTimetables;
import com.abe.service.iBaseService;
import com.abe.service.home.iTimetablesService;
import com.abe.tools.JsonDateValueProcessor;
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
	private Logger log=Logger.getLogger(TimetablesAction.class);
	private iBaseService ser;
	private iTimetablesService timetablesSer;
	private Page page;
	private Course course;
	private Timetables timetables;
	private List<List<Timetables>> tts;
	private String result="timetablesManager";
	private String id;
	private String cz;
	
	
	//---------------------------------------------------
	public Page getPage() {
		return page;
	}
	public List<List<Timetables>> getTts() {
		return tts;
	}
	public void setTts(List<List<Timetables>> tts) {
		this.tts = tts;
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
		timetables.setTId(NameOfDate.getNum());
		ser.save(timetables);
		return gotoQuery();
	}

	@Override
	public void clearOptions() {
		cz=null;
		id=null;
		course=null;
		timetables=null;
		tts=null;
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
			timetables=(Timetables) ser.get(Timetables.class, id);
			if (timetables!=null) {
				ser.delete(timetables);
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
			page=new Page(1, 0, 1);
		}
		StringBuffer hql=new StringBuffer("from SchoolClass");
		List<SchoolClass> list=ser.query(hql.toString(), null, hql.toString(), page);
		tts=new ArrayList<List<Timetables>>();
		for (int i = 0; i < list.size(); i++) {
			SchoolClass schoolClass=(SchoolClass) ser.get(SchoolClass.class, list.get(i).getScId());
			if (schoolClass!=null) {
				tts=timetablesSer.getAllOfWeek(list.get(i).getScId());
			}
		}
		//带上教师和科目信息
		getRequest().setAttribute("teas", timetablesSer.getTeachers());
		getRequest().setAttribute("cous", timetablesSer.getCourses());
		getRequest().setAttribute("scas", timetablesSer.getSclass());
		return result;
	} 

	/**
	 * 张顺 2016-11-12
	 * <br>从APP查本周的课程表
	 * @return
	 * @throws IOException 
	 */
	public String queryFromApp() throws IOException {
		RespTimetables timetable=new RespTimetables();
		String scId=ser.clearSpace(getRequest(), "scId");
		if (scId==null) {
			timetable.setResult("003");
	        timetable.setData(null);
		}else {
			SchoolClass schoolClass=(SchoolClass) ser.get(SchoolClass.class, scId);
			if (schoolClass==null) {
				timetable.setResult("002");
		        timetable.setData(null);
			}else {
				List<List<Timetables>> list=timetablesSer.getAllOfWeek(scId);
				timetable.setResult("001");
				timetable.setData(list);
			}
		}
        JSONObject jsonObject=ser.objToJson(timetable);
        sendToApp(jsonObject, ser);
		return null;
	}
	
	/**
	 * 张顺 2016-12-12
	 * 查看一天的课程表
	 * @return
	 */
	public String queryDateFromApp(){
		RespCommon resp=new RespCommon();
		String scId=ser.clearSpace(getRequest(), "scId");
		String week=ser.clearSpace(getRequest(), "TWeek");
		if (scId!=null && week!=null) {
			SchoolClass schoolClass=(SchoolClass) ser.get(SchoolClass.class, scId);
			if (schoolClass==null) {
				resp.setResult("002");
				resp.setData(null);
			}else {
				int w=Integer.valueOf(week);
				if (w>=1 && w<=7) {
					List<List<Timetables>> list=timetablesSer.getDateOfWeek(scId, w);
					resp.setResult("001");
					resp.setData(list);
				}else {
					resp.setResult("004");
					resp.setData(null);
				}
			}
		}else {
			resp.setResult("003");
			resp.setData(null);
		}
		sendToApp(resp, ser);
		return null;
	}
	
	@Override
	public String queryOfFenYe() {
		clearSpace();
		if (cz!=null && cz.equals("yes")) {
			clearOptions();
		}
		if (page==null) {
			page=new Page(1, 0, 1);
		}
		StringBuffer hql=new StringBuffer("from SchoolClass where 1=1 ");
		if (id!=null) {
			hql.append("and scId like '%"+id+"%'" );
		}
		hql.append("");
		List<SchoolClass> list=ser.query(hql.toString(), null, hql.toString(), page);
		tts=new ArrayList<List<Timetables>>();
		for (int i = 0; i < list.size(); i++) {
			SchoolClass schoolClass=(SchoolClass) ser.get(SchoolClass.class, list.get(i).getScId());
			if (schoolClass!=null) {
				tts=timetablesSer.getAllOfWeek(list.get(i).getScId());
			}
		}
		//带上教师和科目信息
		getRequest().setAttribute("teas", timetablesSer.getTeachers());
		getRequest().setAttribute("cous", timetablesSer.getCourses());
		getRequest().setAttribute("scas", timetablesSer.getSclass());
		return result;
	}

	@Override
	public String update() {
		clearSpace();
		//装载Time字段
		String stime=ser.clearSpace(getRequest(), "time1");
		String etime=ser.clearSpace(getRequest(), "time2");
		if (timetables!=null) {
			if (stime!=null) {
				String ss[]=stime.split(":");
				timetables.setTStartTime(new Time(Integer.valueOf(ss[0]), Integer.valueOf(ss[1]), 0));
			}
			if (etime!=null) {
				String ss[]=etime.split(":");
				timetables.setTEndTime(new Time(Integer.valueOf(ss[0]), Integer.valueOf(ss[1]), 0));
			}
			List<Timetables> list=ser.find("from Timetables where scId=? and TWeek=? and TOrder=?", new Object[]{timetables.getScId(),timetables.getTWeek(),timetables.getTOrder()});
			if (list.size()>0) {
				timetables.setTId(list.get(0).getTId());
				ser.update(timetables);
			}else {
				timetables.setTId(NameOfDate.getNum());
				ser.save(timetables);
			}
		}
		return gotoQuery();
	}

}
