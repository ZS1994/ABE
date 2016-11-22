/**
 * 
 */
package com.abe.service.home.impl;

import java.util.List;

import com.abe.entity.Score;
import com.abe.service.home.iScoreService;
import com.abe.service.impl.BaseServiceImpl;


public class ScoreServiceImpl extends BaseServiceImpl implements iScoreService{

	@Override
	public Score get(String isId) {
		Score s = null;
		List<Score> ls = find("from Score where isId =?", new String[]{isId});
		if(ls.size()>0){
			s = ls.get(0);
		}
		return s;
	}

}
