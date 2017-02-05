package com.abe.service.information.impl;

import java.util.List;

import com.abe.entity.InfoTeacher;
import com.abe.entity.SchoolGrade;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.service.information.iSchoolClassService;

public class SchoolClassServiceImpl extends BaseServiceImpl implements iSchoolClassService{

	@Override
	public List<SchoolGrade> getSgs() {
		return find("from SchoolGrade", null);
	}

	@Override
	public List<InfoTeacher> getTeas() {
		return find("from InfoTeacher", null);
	}


}
