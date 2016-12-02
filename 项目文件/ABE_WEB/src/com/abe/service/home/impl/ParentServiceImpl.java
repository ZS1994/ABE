package com.abe.service.home.impl;

import java.util.List;

import com.abe.entity.InfoParents;
import com.abe.service.home.iParentService;
import com.abe.service.impl.BaseServiceImpl;

public class ParentServiceImpl extends BaseServiceImpl implements iParentService{

	@Override
	public List<InfoParents> getAllParents() {
		return find("from InfoParents", null);
	}
	
	
}
