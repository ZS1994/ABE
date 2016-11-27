package com.abe.service.home.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.filefilter.NameFileFilter;

import com.abe.entity.InfoParents;
import com.abe.entity.InfoStudent;
import com.abe.entity.School;
import com.abe.entity.SchoolClass;
import com.abe.entity.SchoolGrade;
import com.abe.entity.StudentParentRel;
import com.abe.entity.app.ReqObject;
import com.abe.entity.app.RespCommon;
import com.abe.entity.app.RespStudent;
import com.abe.service.home.iStudentService;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.tools.NameOfDate;
import com.opensymphony.xwork2.util.finder.ClassFinder.Info;

public class StudentServiceImpl extends BaseServiceImpl implements iStudentService{

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
		String isNum=clearSpace(req, "isNum");
		String isName=clearSpace(req, "isName");
		String isSex=clearSpace(req, "isSex");
		String isBirthday=clearSpace(req, "isBirthday");
		String isLocal=clearSpace(req, "isLocal");
		String isTeacherChildren=clearSpace(req, "isTeacherChildren");
		String isIntoDate=clearSpace(req, "isIntoDate");
		String isLeaveDate=clearSpace(req, "isLeaveDate");
		String isState=clearSpace(req, "isState");
		String scId=clearSpace(req, "scId");
		String ipId=clearSpace(req, "ipId");
		String spRelation=clearSpace(req, "spRelation");
		if (isNum==null) {
			respStudent.setResult("003");//学号为空
			respStudent.setData(null);
		}else {
			InfoStudent stutmp=getFromNum(isNum);
			if (stutmp!=null) {
				respStudent.setResult("002");//该学号已存在
				respStudent.setData(null);
			}else {
				//保存学生信息
				InfoStudent student=new InfoStudent(NameOfDate.getNum(), isNum, isName, isSex, toDate(isBirthday), toInteger(isLocal), toInteger(isTeacherChildren),toDate(isIntoDate), toDate(isLeaveDate), isState, scId);
				save(student);
				InfoStudent studenttmp=(InfoStudent) get(InfoStudent.class, student.getIsId());
				//绑定家长学生
				if (ipId==null) {
					respStudent.setResult("004");//成功
					respStudent.setData(null);
				}else {
					InfoParents parent=(InfoParents) get(InfoParents.class, ipId);
					if (parent==null) {
						respStudent.setResult("005");//成功
						respStudent.setData(null);
					}else {
						//先清除也许可能出现的重复,确保不会出现意外
						List<StudentParentRel> rels=find("from StudentParentRel where isId=? and ipId=?",new String[]{student.getIsId(),ipId});
						for (int i = 0; i < rels.size(); i++) {
							delete(rels.get(i));
						}
						//保存绑定关系
						StudentParentRel rel=new StudentParentRel(NameOfDate.getNum(), student.getIsId(), ipId, spRelation); 
						save(rel);
						respStudent.setResult("001");//成功
						//装填学生的其他信息
						studenttmp=initStudent(studenttmp);
						respStudent.setData(studenttmp);
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



}
