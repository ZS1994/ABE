package com.abe.service.home.impl;

import java.util.List;

import com.abe.entity.Course;
import com.abe.service.home.iCourseService;
import com.abe.service.impl.BaseServiceImpl;

public class CourseServiceImpl extends BaseServiceImpl implements iCourseService{

	@Override
	public List<Course> queryAll() {
		return find("from Course", null);
	}

}
