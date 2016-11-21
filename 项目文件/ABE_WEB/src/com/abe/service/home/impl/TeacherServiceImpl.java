package com.abe.service.home.impl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.abe.entity.InfoTeacher;
import com.abe.entity.app.RespTeacher;
import com.abe.service.home.iTeacherService;
import com.abe.service.impl.BaseServiceImpl;

public class TeacherServiceImpl extends BaseServiceImpl implements iTeacherService{
	
	@SuppressWarnings("unchecked")
	@Override
	public InfoTeacher get(String itNum) {
		InfoTeacher teacher=null;
		List<InfoTeacher> teac=find("from InfoTeacher where itNum=?", new String[]{itNum});
		if (teac.size()>0) {
			teacher=teac.get(0);
		}
		return teacher;
	}

	@Override
	public void csReq(HttpServletRequest req) {
		
	}

	@Override
	public String queryTeacher(String uId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from users u,infoTeacher t where u.trpId = t.Id ");
		sb.append(" u.uId ="+uId+"");
//		InfoTeacher teacher=new InfoTeacher();
//		List<InfoTeacher> teac=find("from InfoTeacher t,Users u where u.trpId = t.Id and u.unum", new String[]{uNum,trpId});
//		if (teac.size()>0) {
//			teacher=teac.get(0);
//		}
		return sb.toString();
	}



	/*@Override
	public InfoStudent get(String isNum) {
		InfoStudent student=null;
		List<InfoStudent> stus=find("from InfoStudent where isNum=?", new String[]{isNum});
		if (stus.size()>0) {
			student=stus.get(0);
		}
		return student;
	}

	@Override
	public RespStudent addFromApp(HttpServletRequest req) {
		RespStudent respStudent=new RespStudent();
		
		//接收数据
		ReqObject reqObject=new ReqObject(req);
		reqObject.add("isNum");
		reqObject.add("isName");
		reqObject.add("isSex");
		reqObject.add("isBirthday");
		reqObject.add("isAge");
		reqObject.add("isLocal");
		reqObject.add("isTeacherChildren");
		reqObject.add("isSchool");
		reqObject.add("isGrade");
		reqObject.add("isClass");
		reqObject.add("isIntoYear");
		reqObject.add("isParentName");
		reqObject.add("isParentPhone");
		reqObject.add("isParentRelation");
		reqObject.add("isIntoDate");
		reqObject.add("isLeaveDate");
		reqObject.add("isState");
		reqObject.add("UId");
		reqObject.add("scId");
		
		if (reqObject.getToString("isNum")==null) {
			respStudent.setResult("003");//学号为空
			respStudent.setData(null);
		}else {
			InfoStudent stutmp=get(reqObject.getToString("isNum"));
			if (stutmp!=null) {
				respStudent.setResult("002");//该学号已存在
				respStudent.setData(null);
			}else {
				//保存学生信息
				InfoStudent student=new InfoStudent();
				student.setIsId(NameOfDate.getNum());
				student.setIsNum(reqObject.getToString("isNum"));
				student.setIsName(reqObject.getToString("isName"));
				student.setIsSex(reqObject.getToString("isSex"));
				student.setIsBirthday(reqObject.getToDate("isBirthday"));
				student.setIsAge(reqObject.getToInteger("isAge"));
				student.setIsLocal(reqObject.getToInteger("isLocal"));
				student.setIsTeacherChildren(reqObject.getToInteger("isTeacherChildren"));
				student.setIsSchool(reqObject.getToString("isSchool"));
				student.setIsGrade(reqObject.getToString("isGrade"));
				student.setIsClass(reqObject.getToString("isClass"));
				student.setIsIntoYear(reqObject.getToDate("isIntoYear"));
				student.setIsParentName(reqObject.getToString("isParentName"));
				student.setIsParentPhone(reqObject.getToString("isParentPhone"));
				student.setIsParentRelation(reqObject.getToString("isParentRelation"));
				student.setIsIntoDate(reqObject.getToDate("isIntoDate"));
				student.setIsLeaveDate(reqObject.getToDate("isLeaveDate"));
				student.setIsState(reqObject.getToString("isState"));
				student.setUId(reqObject.getToString("UId"));
				student.setScId(reqObject.getToString("scId"));
				save(student);
				InfoStudent studenttmp=(InfoStudent) get(InfoStudent.class, student.getIsId());
				respStudent.setResult("001");//成功
				respStudent.setData(studenttmp);
			}
		}
		return respStudent;
	}

	@Override
	public void csReq(HttpServletRequest req) {
		//测试添加宝贝
		System.out.println("----csReq------->>"+req.getParameter("isNum"));
		//2016-11-2  张顺  成功
	}*/

}
