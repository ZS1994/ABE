package com.abe.service.home.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.abe.entity.PersonInform;
import com.abe.entity.Users;
import com.abe.entity.other.RespPersonInform;
import com.abe.entity.other.RespPersonInformAll;
import com.abe.service.home.iPersonInformService;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;

public class PersonInformServiceImpl extends BaseServiceImpl implements
		iPersonInformService {

	@Override
	public RespPersonInform insertPersonInform(String piTitle,String piContent,String uId) {
		RespPersonInform respPersonInform = new RespPersonInform();
		PersonInform personInform =new PersonInform();
		if (piTitle==null||"".equals(piTitle)){
			respPersonInform.setData(null);
			respPersonInform.setResult("002");
		} else if(piContent==null||"".equals(piContent)){
			respPersonInform.setData(null);
			respPersonInform.setResult("003");
		} else if(uId==null||"".equals(uId)){
			respPersonInform.setData(null);
			respPersonInform.setResult("004");
		}else{
			String time = getTime();
			NameOfDate nameOfData = new NameOfDate();
			String piId = nameOfData.getNum();
			
			personInform.setPiId(piId);
			personInform.setPiTitle(piTitle);
			personInform.setPiContent(piContent);
			personInform.setPiTime(time);
			personInform.setPiStatus("已发送");
			personInform.setUId(uId);
			save(personInform);
			
			respPersonInform.setData(personInform);
			respPersonInform.setResult("001");
		}
		return null;
	}

	@Override
	public RespPersonInform deletePersonInform() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RespPersonInform findSinglePersonInform(String piId) {
		PersonInform personInform =(PersonInform) get(PersonInform.class,piId);
		personInform.setPiStatus("已读");
		update(personInform);
		RespPersonInform respPersonInform = new RespPersonInform("001",personInform);
		return respPersonInform;
	}

	@Override
	public RespPersonInformAll findByPage(String pageNo,String pageSize) {
		RespPersonInformAll respPersonInformAll=new RespPersonInformAll();
		int pano = Integer.valueOf(pageNo);
		int size = Integer.valueOf(pageSize);
		if (pano<=0) {
			respPersonInformAll.setResult("002");
			respPersonInformAll.setData(null);
		}else if (size<=0) {
			respPersonInformAll.setResult("003");
			respPersonInformAll.setData(null);
		}else {
			Page page=new Page(pano, 0, size);
		String hql1="from PersonInform order by piTime desc ";
		List<PersonInform> list = query(hql1, null, hql1, page);
		for (int i = 0; i < list.size(); i++) {
			Users user=(Users) get(Users.class, list.get(i).getUId());
			user.setUPass(null);
			list.get(i).setUser(user);
		}
		if (list.size()>0){
			respPersonInformAll.setData(list);
			respPersonInformAll.setResult("001");
		}else {
			respPersonInformAll.setData(null);
			respPersonInformAll.setResult("004");
		}
		}
		return respPersonInformAll;
	}

	@Override
	public RespPersonInformAll queryPersonInformByUId(String pageNo,String pageSize,String uId) {
		RespPersonInformAll respPersonInformAll = new RespPersonInformAll();
		PersonInform personInform = new PersonInform();
		int pano = Integer.valueOf(pageNo);
		int size = Integer.valueOf(pageSize);

		if (pano<=0) {

			respPersonInformAll.setResult("002");
			respPersonInformAll.setData(null);
		}else if (size<=0) {

			respPersonInformAll.setResult("003");
			respPersonInformAll.setData(null);
		}else {

			Page page=new Page(pano, 0, size);
			String hql1="from PersonInform where UId = ? order by piTime desc";
			String hql2="from PersonInform where UId = '"+uId+"' order by piTime desc";
			List<PersonInform> list = query(hql1, new String[]{uId}, hql2, page);
			for (int i = 0; i < list.size(); i++) {
				Users user=(Users) get(Users.class, list.get(i).getUId());
				user.setUPass(null);
				list.get(i).setUser(user);
			}
			if (list.size()>0){

				respPersonInformAll.setData(list);
				respPersonInformAll.setResult("001");
			}else {

				respPersonInformAll.setData(null);
				respPersonInformAll.setResult("004");
			}
		}
		return respPersonInformAll;
	}
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		return time;
	}
}
