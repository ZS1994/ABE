package com.abe.service.information;

import java.util.List;

import com.abe.entity.InfoTeacher;
import com.abe.entity.SchoolGrade;

public interface iSchoolClassService {
	
	/**
	 * 得到年级
	 * @return
	 */
	public List<SchoolGrade> getSgs();
	
	
	/**
	 * 得到教师
	 * @return
	 */
	public List<InfoTeacher> getTeas();
	
	
	
}
