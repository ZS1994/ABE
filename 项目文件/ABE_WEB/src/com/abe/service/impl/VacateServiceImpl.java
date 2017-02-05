package com.abe.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.abe.entity.Forum;
import com.abe.entity.InfoStudent;
import com.abe.entity.InfoTeacher;
import com.abe.entity.Users;
import com.abe.entity.Vacate;
import com.abe.entity.other.RespRecipeAll;
import com.abe.entity.other.RespVacate;
import com.abe.entity.other.RespVacateAll;
import com.abe.service.iVacateService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;

public class VacateServiceImpl extends BaseServiceImpl implements
		iVacateService {

	@Override
	public RespVacate createVacate(String isId, String uId, String itId,
			String vContent, String vDate) {
		RespVacate respVacate = new RespVacate();
		Vacate vacate = new Vacate();
		
		if (isId==null||"".equals(isId)){
			respVacate.setData(null);
			respVacate.setResult("002");
		} else if(itId==null||"".equals(itId)){
			respVacate.setData(null);
			respVacate.setResult("003");
			
		} else if(vContent==null||"".equals(vContent)){
			respVacate.setData(null);
			respVacate.setResult("004");
			
		} else if(vDate==null||"".equals(vDate)){
			respVacate.setData(null);
			respVacate.setResult("005");
			
		} else{
		String time = getTime();
		NameOfDate nameOfData = new NameOfDate();
		String vId = nameOfData.getNum();
		
		vacate.setVId(vId);
		vacate.setIsId(isId);
		vacate.setUId(uId);
		vacate.setItId(itId);
		vacate.setVContent(vContent);
		vacate.setVDate(vDate);
		vacate.setVTime(time);
		vacate.setVResp("");
		save(vacate);
		InfoStudent st = (InfoStudent) get(InfoStudent.class,isId);
		InfoTeacher teacher = (InfoTeacher) get(InfoTeacher.class,itId);
		Users user = (Users) get(Users.class,uId);
		user.setUPass(null);
		vacate.setStudent(st);
		vacate.setTeacher(teacher);
		vacate.setUser(user);
		respVacate.setData(vacate);
		respVacate.setResult("001");
		}
		return respVacate;
	}
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		return time;
	}
	@Override
	public RespVacate findSingleVacate(String vId) {
		
		Vacate vacate = (Vacate) get(Vacate.class,vId);
		InfoStudent st = (InfoStudent) get(InfoStudent.class,vacate.getIsId());
		InfoTeacher teacher = (InfoTeacher) get(InfoTeacher.class,vacate.getItId());
		Users user = (Users) get(Users.class,vacate.getUId());
		user.setUPass(null);
		vacate.setStudent(st);
		vacate.setTeacher(teacher);
		vacate.setUser(user);
		RespVacate respVacate = new RespVacate("001",vacate);
		return respVacate;
	}

	@Override
	public RespVacate respsVacate(String vId, String isId, String uId,
			String itId, String vContent, String vDate, String vResp,String vTime) {
		RespVacate respVacate = new RespVacate();
		Vacate vacate = new Vacate();
		if(vResp==null||"".equals(vResp)){
			respVacate.setData(null);
			respVacate.setResult("002");
		}else{
		vacate.setVId(vId);
		vacate.setIsId(isId);
		vacate.setUId(uId);
		vacate.setItId(itId);
		vacate.setVContent(vContent);
		vacate.setVDate(vDate);
		vacate.setVResp(vResp);
		vacate.setVTime(vTime);
		update(vacate);
		InfoStudent st = (InfoStudent) get(InfoStudent.class,isId);
		InfoTeacher teacher = (InfoTeacher) get(InfoTeacher.class,itId);
		Users user = (Users) get(Users.class,uId);
		user.setUPass(null);
		vacate.setStudent(st);
		vacate.setTeacher(teacher);
		vacate.setUser(user);
		respVacate.setResult("001");
		}
		return respVacate;
	}

	@Override
	public RespVacateAll findOwnerVacate(String uId,String pageNo,String pageSize) {
		RespVacateAll respVacateAll = new RespVacateAll();
		Vacate vacate = new Vacate();
		int pano = Integer.valueOf(pageNo);
		int size = Integer.valueOf(pageSize);

		if (pano<=0) {

			respVacateAll.setResult("002");
			respVacateAll.setData(null);
		}else if (size<=0) {

			respVacateAll.setResult("003");
			respVacateAll.setData(null);
		}else {

			Page page=new Page(pano, 0, size);
			Users user =(Users) get(Users.class,uId);
			if(user!=null){	

				String type = user.getUType();
				System.out.println(type);
				if("1".equals(type)){

					String hql1="from Vacate where UId = ? order by VTime";
					String hql2="from Vacate where UId = '"+uId+"' order by VTime";
					List<Vacate> list = query(hql1, new String[]{uId}, hql2, page);
					for (int i = 0; i < list.size(); i++) {
						user=(Users) get(Users.class, list.get(i).getUId());
						user.setUPass(null);
						list.get(i).setUser(user);
					}
					if (list.size()>0){

						respVacateAll.setData(list);
						respVacateAll.setResult("001");
					}else {

						respVacateAll.setData(null);
						respVacateAll.setResult("004");//当前用户下没有请假条或页数超限
					}
				}else if("2".equals(type)){

					String hql1="from Vacate where itId = ? order by VTime";
					String hql2="from Vacate where itId = '"+user.getTrpId()+"' order by VTime";
					List<Vacate> list = query(hql1, new String[]{uId}, hql2, page);
					for (int i = 0; i < list.size(); i++) {
						user=(Users) get(Users.class, list.get(i).getUId());
						user.setUPass(null);
						list.get(i).setUser(user);
					}
					if (list.size()>0){

						respVacateAll.setData(list);
						respVacateAll.setResult("001");
					}else {

						respVacateAll.setData(null);
						respVacateAll.setResult("005");//当前用户下没有请假条或页数超限
					}	
				}else{
					respVacateAll.setData(null);
					respVacateAll.setResult("007");//有用户但类型不是教师也不是家长
				}
			}else{

				respVacateAll.setData(null);
				respVacateAll.setResult("006");//用户不存在
			}
		}

		return respVacateAll;
	}

	@Override
	public RespVacateAll findAllVacate(String pageNo,String pageSize) {
		RespVacateAll respVacateAll = new RespVacateAll();
		Vacate Vacate = new Vacate();		
		
		int pano = 0;
		pano=pageNo==null?0:Integer.valueOf(pageNo);
		int size = 0;
		size=pageSize==null?0:Integer.valueOf(pageSize);
		
		if (pano<=0) {
			respVacateAll.setResult("002");
			respVacateAll.setData(null);
		}else if (size<=0) {
			respVacateAll.setResult("003");
			respVacateAll.setData(null);
		}else {
			Page page=new Page(pano, 0, size);
			String hql="from Vacate order by VTime desc";
			List<Vacate> vacate=query(hql, null, hql, page); 
			for (int i = 0; i < vacate.size(); i++) {
				Users user=(Users) get(Users.class, vacate.get(i).getUId());
				user.setUPass(null);
				vacate.get(i).setUser(user);
			}
			respVacateAll.setResult("001");
			respVacateAll.setData(vacate);
		}
		return respVacateAll;
	}


}
