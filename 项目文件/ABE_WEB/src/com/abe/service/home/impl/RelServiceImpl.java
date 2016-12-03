package com.abe.service.home.impl;

import java.util.List;

import com.abe.entity.InfoParents;
import com.abe.entity.InfoStudent;
import com.abe.entity.StudentParentRel;
import com.abe.service.home.iRelService;
import com.abe.service.impl.BaseServiceImpl;
import com.opensymphony.xwork2.util.finder.ClassFinder.Info;

public class RelServiceImpl extends BaseServiceImpl implements iRelService{

	@Override
	public List<StudentParentRel> initRel(List<StudentParentRel> rels) {
		if (rels!=null) {
			for (int i = 0; i < rels.size(); i++) {
				InfoParents p=(InfoParents) get(InfoParents.class, rels.get(i).getIpId());
				InfoStudent s=(InfoStudent) get(InfoStudent.class, rels.get(i).getIsId());
				rels.get(i).setParent(p);
				rels.get(i).setStudent(s);
			}
		}
		return rels;
	}


	
	
}
