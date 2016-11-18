package com.abe.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.abe.entity.Recipe;
import com.abe.entity.Users;
import com.abe.entity.Vacate;
import com.abe.entity.app.RespRecipe;
import com.abe.entity.app.RespVacate;
import com.abe.entity.app.RespVacateAll;
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
		NameOfDate nameOfData = new NameOfDate();
		
		String time = getTime();
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
		vacate.setVId(nameOfData.getNum());
		vacate.setIsId(isId);
		vacate.setUId(uId);
		vacate.setItId(itId);
		vacate.setVContent(vContent);
		vacate.setVDate(vDate);
		vacate.setVTime(time);
		save(vacate);
		
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
		
		respVacate.setData(vacate);
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
			if(user!=null&&!"".equals(user)){	
				String type = user.getUType();
				if(type=="1"){
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
						respVacateAll.setResult("004");
					}
				}else if(type=="2"){
					String hql1="from Vacate where ItId = ? order by VTime";
					String hql2="from Vacate where ItId = '"+user.getTrpId()+"' order by VTime";
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
						respVacateAll.setResult("005");
					}	
				}else{
					
				}
			}else{
				respVacateAll.setData(null);
				respVacateAll.setResult("006");
			}
		}
		return respVacateAll;
	}

	@Override
	public RespVacateAll findAllVacate(String pageNo,String pageSize) {
		// TODO Auto-generated method stub
		return null;
	}


}
