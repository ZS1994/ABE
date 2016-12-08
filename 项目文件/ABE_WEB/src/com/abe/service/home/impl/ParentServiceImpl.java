package com.abe.service.home.impl;

import java.util.List;

import com.abe.entity.InfoParents;
import com.abe.entity.app.RespCommon;
import com.abe.service.home.iParentService;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.tools.NameOfDate;

public class ParentServiceImpl extends BaseServiceImpl implements iParentService{

	@Override
	public List<InfoParents> getAllParents() {
		return find("from InfoParents", null);
	}

	@Override
	public RespCommon addFromApp(InfoParents parent,String code) {
		if (parent!=null && code!=null) {
			  parent.setIpId(NameOfDate.getNum());
			  
			  
			  
			  
			  
		}
		return null;
	}

	@Override
	public RespCommon getCode() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
