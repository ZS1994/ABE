package com.abe.service.home.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.filefilter.NameFileFilter;

import com.abe.entity.HxGroup;
import com.abe.entity.InfoParents;
import com.abe.entity.InfoStudent;
import com.abe.entity.InfoTeacher;
import com.abe.entity.School;
import com.abe.entity.SchoolClass;
import com.abe.entity.SchoolGrade;
import com.abe.entity.StudentParentRel;
import com.abe.entity.Users;
import com.abe.entity.app.ReqObject;
import com.abe.entity.app.RespCommon;
import com.abe.entity.app.RespStudent;
import com.abe.service.home.iStudentService;
import com.abe.service.hx.iChatgroupService;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.tools.NameOfDate;
import com.opensymphony.xwork2.util.finder.ClassFinder.Info;

public class StudentServiceImpl extends BaseServiceImpl implements iStudentService{

	private iChatgroupService groupSer;
	
	
	public iChatgroupService getGroupSer() {
		return groupSer;
	}
	public void setGroupSer(iChatgroupService groupSer) {
		this.groupSer = groupSer;
	}
	//-----------------------------------
	@Override
	public InfoStudent getFromNum(String isNum) {
		InfoStudent student=null;
		List<InfoStudent> stus=find("from InfoStudent where isNum=?", new String[]{isNum});
		if (stus.size()>0) {
			student=stus.get(0);
			student=initStudent(student);
		}
		return student;
	}

	/**
	 * 张顺 数据
	 * 装填学生信息
	 */
	private InfoStudent initStudent(InfoStudent student) {
		//装填家长信息
		List<StudentParentRel> rels=find("from StudentParentRel where isId=?", new String[]{student.getIsId()});
		List<InfoParents> parents=new ArrayList<InfoParents>();
		for (int i = 0; i < rels.size(); i++) {
			InfoParents parent=(InfoParents) get(InfoParents.class, rels.get(i).getIpId()); 
			parent.setSpRelation(rels.get(i).getSpRelation());
			parents.add(parent);
		}
		student.setParents(parents);
		//装填学校信息
		SchoolClass schoolClass=(SchoolClass) get(SchoolClass.class, student.getScId());
		if (schoolClass.getSgId()!=null) {
			SchoolGrade schoolGrade=(SchoolGrade) get(SchoolGrade.class, schoolClass.getSgId());
			if (schoolGrade.getSId()!=null) {
				School school=(School) get(School.class, schoolGrade.getSId());
				schoolGrade.setSchool(school);
			}
			schoolClass.setSchoolGrade(schoolGrade);
		}
		student.setSchoolClass(schoolClass);
		return student;
	}
	
	@Override
	public RespStudent addFromApp(HttpServletRequest req) {
		RespStudent respStudent=new RespStudent();
		//接收数据
		String isId=clearSpace(req, "isId");
		String ipId=clearSpace(req, "ipId");
		String spRelation=clearSpace(req, "spRelation");
		respStudent=addRel(ipId, isId, spRelation);
		return respStudent;
	}

	@Override
	public RespStudent addRel(String ipId, String isId, String spRelation) {
		RespStudent respStudent=new RespStudent();
		if (isId!=null && ipId!=null && spRelation!=null) {
			InfoStudent stutmp=(InfoStudent) get(InfoStudent.class, isId);
			InfoParents parent=(InfoParents) get(InfoParents.class, ipId);
			if (stutmp==null) {
				respStudent.setResult("002");
				respStudent.setData(null);
			}else if (parent==null) {
				respStudent.setResult("003");
				respStudent.setData(null);
			}else {
				//绑定家长学生
				//先清除也许可能出现的重复,确保不会出现意外
				List<StudentParentRel> rels=find("from StudentParentRel where isId=? and ipId=?",new String[]{isId,ipId});
				for (int i = 0; i < rels.size(); i++) {
					delete(rels.get(i));
				}
				//保存绑定关系
				StudentParentRel rel=new StudentParentRel(NameOfDate.getNum(), isId, ipId, spRelation); 
				save(rel);
				respStudent.setResult("001");//成功
				respStudent.setData(null);
				//将家长加入到班主任的群组中
				//1得到学生所在班级
				SchoolClass schcla=(SchoolClass) get(SchoolClass.class, stutmp.getScId());
				if (schcla!=null) {
					//2得到班主任
					InfoTeacher tea=(InfoTeacher) get(InfoTeacher.class, schcla.getItId()); 
					if (tea!=null) {
						//3得到班主任的用户
						List<Users> users1=find("from Users where UType=2 and trpId=?", new String[]{tea.getItId()});
						//4得到用户
						List<Users> users2=find("from Users where UType=1 and trpId=?", new String[]{ipId});
						if (users1.size()>0 && users2.size()>0) {
							Users t=users1.get(0);
							Users u=users2.get(0);
							//5得到最新的一个群组
							List<HxGroup> groups=find("from HxGroup where UId=? and GNote='native' order by GCreateTime desc", new String[]{t.getUId()});
							if (groups.size()>0) {
								HxGroup group=groups.get(0);
								groupSer.addUser(u, group);
							}
						}
					}
				}
			}
		}
		return respStudent;
	}
	
	
	@Override
	public InfoStudent getFromId(String isId) {
		if (isId!=null) {
			InfoStudent student=(InfoStudent) get(InfoStudent.class, isId);
			if (student!=null) {
				student=initStudent(student);
				return student;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	
	
	@Override
	public List<InfoStudent> getAllStu() {
		return find("from InfoStudent", null);
	}
	



}
