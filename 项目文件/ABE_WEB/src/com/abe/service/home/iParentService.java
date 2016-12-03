package com.abe.service.home;

import java.util.List;

import com.abe.entity.InfoParents;

public interface iParentService {
	
	/**
	 * 张顺 2016-12-1
	 * 得到所有的家长档案信息
	 * @return
	 */
	public List<InfoParents> getAllParents();
	
}
