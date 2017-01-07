package com.abe.service.home.impl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.abe.entity.InfoTeacher;
import com.abe.entity.SchoolClass;
import com.abe.entity.SchoolSection;
import com.abe.entity.Users;
import com.abe.entity.other.RespCommon;
import com.abe.entity.other.RespTeacher;
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

	/* (non-Javadoc)
	 * @see com.abe.service.home.iTeacherService#addTeacherInfor(com.abe.entity.InfoTeacher)
	 */
	


	/*@Override
	public InfoStudent get(String isNum) {
		InfoStudent student=null;
		List<InfoStudent> stus=find("from InfoStudent where isNum=?", new String[]{isNum});
		if (stus.size()>0) {
			student=stus.get(0);
		}
		return student;
	}*/

	/*@Override
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
	}*/

	/*@Override
	public void csReq(HttpServletRequest req) {
		//测试添加宝贝
		System.out.println("----csReq------->>"+req.getParameter("isNum"));
		//2016-11-2  张顺  成功
	}*/
	/**
	 * web添加教师档案
	 * teacher
	 * 2016-12-5
	 * 卢江林
	 */
	@Override
	public InfoTeacher addTeacherInfor(InfoTeacher teacher) {
		InfoTeacher teacher1 = new  InfoTeacher();
		
		
		return teacher;
	}

	@Override
	public void initTeacher(InfoTeacher techer) {
		if (techer!=null && techer.getSsId()!=null) {
			SchoolSection ss=(SchoolSection) get(SchoolSection.class, techer.getSsId());
			if (ss!=null) {
				techer.setSchoolSection(ss);
			}
		}
		
	}
	@Override
	public void initTeacher(List<InfoTeacher> techers) {
		if (techers!=null) {
			for (int i = 0; i < techers.size(); i++) {
				initTeacher(techers.get(i));
			}
		}
		
	}

	@Override
	public List getSsals() {
		return find("from SchoolSection", null);
	}

	@Override
	public RespCommon querySchoolClass(String uid) {
		RespCommon resp=new RespCommon();
		if (uid!=null) {
			Users user=(Users) get(Users.class, uid);
			if (user!=null) {
				if (user.getUType()!=null && user.getUType().equals("2")) {
					if (user.getTrpId()!=null) {
						InfoTeacher teacher=(InfoTeacher) get(InfoTeacher.class, user.getTrpId());
						if (teacher!=null) {
							List<SchoolClass> scs=find("from SchoolClass where itId=? and scState='有效' order by scCreateTime ", new String[]{teacher.getItId()});
							resp.setResult("001");
							resp.setData(scs);
							return resp;
						}else {
							resp.setResult("004");
							resp.setData(null);
							return resp;
						}
					}else {
						resp.setResult("003");
						resp.setData(null);
						return resp;
					}
				}else {
					resp.setResult("002");
					resp.setData(null);
					return resp;
				}
			}
		}
		resp.setResult("2001");
		resp.setData(null);
		return resp;
	}



}
