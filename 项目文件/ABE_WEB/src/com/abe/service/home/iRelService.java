package com.abe.service.home;

import java.util.List;

import com.abe.entity.StudentParentRel;

public interface iRelService {
	
	/**
	 * 张顺 2016-12-1
	 * 组装关系
	 * @return
	 */
	public List<StudentParentRel> initRel(List<StudentParentRel> rels);
	
}
