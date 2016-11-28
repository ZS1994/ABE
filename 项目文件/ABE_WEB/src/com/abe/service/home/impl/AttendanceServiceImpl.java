/**
 * 
 */
package com.abe.service.home.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.abe.entity.Card;
import com.abe.entity.CardLog;
import com.abe.entity.Course;
import com.abe.entity.InfoParents;
import com.abe.entity.InfoStudent;
import com.abe.entity.Score;
import com.abe.entity.StudentParentRel;
import com.abe.entity.Users;
import com.abe.service.home.iAttendanceService;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.tools.NameOfDate;

/**
 * @author 张顺
 *
 */
public class AttendanceServiceImpl extends BaseServiceImpl implements iAttendanceService{

	@Override
	public void add(String CId, String clState) {
		CardLog cardlog = new CardLog();
		cardlog.setClId(NameOfDate.getNum());
		cardlog.setCId(CId);
		cardlog.setClState(clState);
		cardlog.setClTime(new Timestamp(new Date().getTime()));
		save(cardlog);
	}

	@Override
	public List queryAll() {
		List<CardLog> list = find("from CardLog",null);
		return list;
	}

	@Override
	public List queryOfCid(String CId) {
		List<CardLog> list = find("from CardLog where CId = ?",new String[]{CId} );
		
		return list;
	}

	@Override
	public List queryOfUid(String UId) {
		//声明容器备用
		List<InfoStudent> students=new ArrayList<InfoStudent>();
		List<CardLog> logs=new ArrayList<CardLog>();
		//分情况查询
		Users user = (Users) get(Users.class, UId);
		if (user!=null && user.getUType()!=null && user.getUType().trim().equals("1") && user.getTrpId()!=null) {
			InfoParents parent=(InfoParents) get(InfoParents.class, user.getTrpId());
			if (parent!=null) {
				List<StudentParentRel> rels=find("from StudentParentRel where ipId=?", new String[]{parent.getIpId()});
				for (int i = 0; i < rels.size(); i++) {
					InfoStudent student=(InfoStudent) get(InfoStudent.class, rels.get(i).getIsId());
					student=initStudentCardlog(student);
					students.add(student);
				}
				return students;
			}
		}else if (user!=null && user.getUType()!=null && user.getUType().trim().equals("2") && user.getTrpId()!=null) {
			Card card = (Card) find("from Card where strId = ? and CType = '2'",new String[]{user.getTrpId()});
			logs = find("from CardLog where CId = ?",new String[]{card.getCId()});
			return logs;
		}
		return null;
	}

	/**
	 * 装填学生打开考勤信息
	 * @param student
	 * @return
	 */
	private InfoStudent initStudentCardlog(InfoStudent student) {
		if (student!=null) {
			List<Card> cards=find("from Card where srtId=? and CType=1", new String[]{student.getIsId()});
			if (cards.size()>0) {
				Card card=cards.get(0);
				//装填考勤信息
				List<CardLog> cardLogs=find("from CardLog where CId=?", new String[]{card.getCId()});
				student.setCardLogs(cardLogs);
				return student;
			}
		}
		return null;
	}

}
