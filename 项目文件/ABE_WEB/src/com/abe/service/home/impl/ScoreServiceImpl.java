/**
 * 
 */
package com.abe.service.home.impl;

import java.util.ArrayList;
import java.util.List;

import com.abe.entity.Course;
import com.abe.entity.InfoParents;
import com.abe.entity.InfoStudent;
import com.abe.entity.Score;
import com.abe.entity.StudentParentRel;
import com.abe.entity.Users;
import com.abe.service.home.iScoreService;
import com.abe.service.impl.BaseServiceImpl;


public class ScoreServiceImpl extends BaseServiceImpl implements iScoreService{

	@Override
	public List get(String UId) {
		//声明一个容器待用
		List<InfoStudent> students=new ArrayList<InfoStudent>();
		Users user=(Users) get(Users.class, UId);
		if (user!=null && user.getUType()!=null && user.getUType().trim().equals("1") && user.getTrpId()!=null) {
			InfoParents parent=(InfoParents) get(InfoParents.class, user.getTrpId());
			if (parent!=null) {
				List<StudentParentRel> rels=find("from StudentParentRel where ipId=?", new String[]{parent.getIpId()});
				for (int i = 0; i < rels.size(); i++) {
					InfoStudent student=(InfoStudent) get(InfoStudent.class, rels.get(i).getIsId());
					student=initStudentScores(student);
					students.add(student);
				}
			}
		}
		return students;
	}
	
	/**
	 * 装填学生成绩信息
	 * @param student
	 * @return
	 */
	@SuppressWarnings("unused")
	private InfoStudent initStudentScores(InfoStudent student) {
		if (student!=null) {
			List<Score> scores=find("from Score where isId=?", new String[]{student.getIsId()});
			//装填科目信息
			for (int j = 0; j < scores.size(); j++) {
				Course course=(Course) get(Course.class, scores.get(j).getCId());
				scores.get(j).setCourse(course);
			}
			//装填成绩信息
			student.setScores(scores);
		}
		return student;
	}
	
	
	
	@Override
	public List getOfisId(String isId) {
		if (isId!=null) {
			InfoStudent student=(InfoStudent) get(InfoStudent.class, isId);
			if (student!=null) {
				student=initStudentScores(student);
				return student.getScores();
			}
		}
		return null;
	}

}
