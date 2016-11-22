/**
 * 
 */
package com.abe.action.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.InfoStudent;
import com.abe.entity.Score;
import com.abe.entity.Users;
import com.abe.entity.app.RespCommon;
import com.abe.service.iBaseService;
import com.abe.service.home.iScoreService;

/**
 * @author 张顺
 *<br/>查询学生分数信息
 *
 */
public class ScoreAction extends BaseAction implements iBaseAction{
	//service们
	private iBaseService ser;
	private iScoreService scoreSer;
	
	//-------------
	private String result="scoreMassage";
	private String result_fail="";
	
	private Score score;
	
	private Logger logger=Logger.getLogger(ScoreAction.class);
	
	public iBaseService getSer() {
		return ser;
	}

	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	public iScoreService getScoreSer() {
		return scoreSer;
	}

	public void setScoreSer(iScoreService scoreSer) {
		this.scoreSer = scoreSer;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	/**
	 * @author 张顺  2016年11月21日
	 * @return
	 * @throws IOException
	 */
	public String QueryScoreFromApp() throws IOException{
		logger.debug("-------------进入分数查询------------");
		String UId=ser.clearSpace(getRequest(), "UId");
		RespCommon respScore=new RespCommon();
		if (UId==null) {
			respScore.setResult("003");
			respScore.setData(null);
		}else {
			Users user=(Users) ser.get(Users.class, UId);
			if (user==null) {
				respScore.setResult("002");
				respScore.setData(null);
			}else if (user.getUType().equals("1")) {
				List<InfoStudent> list=ser.find("from InfoStudent where UId=?", new String[]{user.getUId()});
				Score sc=null;
				List<Score> lists = new ArrayList<Score>();
				for (int i = 0; i < list.size(); i++) {
					 sc= scoreSer.get(list.get(i).getIsId());
					 lists.add(sc);
				}
				respScore.setResult("001");
				respScore.setData(lists);
			}else {
				respScore.setResult("004");
				respScore.setData(null);
			}
		} 
		JSONObject json=ser.objToJson(respScore);
		sendToApp(json, ser);
		return null;
	}
	
	
	
	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearOptions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearSpace() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String gotoQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryOfFenYe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

}
