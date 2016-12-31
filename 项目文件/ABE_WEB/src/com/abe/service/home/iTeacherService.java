package com.abe.service.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.abe.entity.InfoStudent;
import com.abe.entity.InfoTeacher;
import com.abe.entity.other.RespCommon;
import com.abe.entity.other.RespTeacher;


public interface iTeacherService{
	
	/**卢江林<br>
	 * 通过工号查找老师   2016-11-6
	 * @param itNum 工号
	 * @return
	 */
	public InfoTeacher get(String itNum);
	/**
	 * 查询老师
	 * @param itName 姓名
	 * 2016-11-21
	 * 下午10:19:19
	 * 卢江林
	 */
	//public InfoTeacher get(String itName);
	
	/*
	public RespTeacher addFromApp(HttpServletRequest req);*/
	
	/**
	 * 测试request传过来是否可以取值
	 */
	public void csReq(HttpServletRequest req);

	/**
	 * 查找老师的个人资料
	 * 2016-11-8
	 * 下午10:27:17
	 */
	public String queryTeacher(String uId);

	/**
	 * web添加教师档案
	 * teacher
	 * 2016-12-5
	 * 卢江林
	 */
	public InfoTeacher addTeacherInfor(InfoTeacher teacher);
	/*
	 * 填装部门信息
	 */
	public List getSsals();
	public void initTeacher(InfoTeacher techer);
	public void initTeacher(List<InfoTeacher> techers);
	
	
	/**张顺
	 * 查询有关这个教师的班级
	 */
	public RespCommon querySchoolClass(String uid);
}
