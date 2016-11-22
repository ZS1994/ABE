/**
 * 
 */
package com.abe.service.home.impl;

import java.util.ArrayList;
import java.util.List;

import com.abe.entity.InfoStudent;
import com.abe.entity.Score;
import com.abe.service.home.iScoreService;
import com.abe.service.impl.BaseServiceImpl;


public class ScoreServiceImpl extends BaseServiceImpl implements iScoreService{

	@Override
	public List get(String UId) {
		List<InfoStudent> slist=find("from InfoStudent where UId=?", new String[]{UId});
		List lss= new ArrayList<Score>();
		List<Score> ls=null;
		for (int i = 0; i < slist.size(); i++) {
			ls = find("from Score where isId =?", new String[]{slist.get(i).getIsId()});
			lss.add(ls);
		}
		return lss;
	}
	
	
	@Override
	public List getOfisId(String isId) {
		List<Score> ls = find("from Score where isId =?", new String[]{isId});
		return ls;
	}

}
