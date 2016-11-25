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
import com.abe.entity.InfoStudent;
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
		Users users = (Users) get(Users.class, UId);
		Card card = null;
		List list = new ArrayList();
			if(users.getUType().equals("1")){   //家长
				List<InfoStudent> stulist = find("from InfoStudent where UId = ?",new String[]{UId}); 
				for (int i = 0; i < stulist.size(); i++) {
					List list2=find("from Card where strId = ? and CType = '1'",new String[]{stulist.get(i).getIsId()});
					if (list2.size()>0) {
						card=(Card) list2.get(0);
					}
					List<CardLog> clList = find("from CardLog where CId = ?",new String[]{card.getCId()});
					list.add(clList);
				}
			}else if(users.getUType().equals("2")){ //教职工
				card = (Card) find("from Card where strId = ? and CType = '2'",new String[]{users.getTrpId()});
				list = find("from CardLog where CId = ?",new String[]{card.getCId()});
			}
		return list;
	}

}
