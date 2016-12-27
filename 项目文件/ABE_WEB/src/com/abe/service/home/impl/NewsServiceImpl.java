package com.abe.service.home.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.abe.entity.News;
import com.abe.entity.SchoolClass;
import com.abe.entity.Users;
import com.abe.entity.Vacate;
import com.abe.entity.other.RespNews;
import com.abe.entity.other.RespNewsAll;
import com.abe.service.home.iNewsService;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;

public class NewsServiceImpl extends BaseServiceImpl implements iNewsService {

	@Override
	public RespNewsAll findAllNewsByPage(String pageNo, String pageSize) {
		RespNewsAll respNewsAll = new RespNewsAll();
		int pano = Integer.valueOf(pageNo);
		int size = Integer.valueOf(pageSize);
		if (pano<=0) {
			respNewsAll.setResult("002");
			respNewsAll.setData(null);
		}else if (size<=0) {
			respNewsAll.setResult("003");
			respNewsAll.setData(null);
		}else {
			Page page=new Page(pano, 0, size);
		String hql1="from News order by NFinalTime desc ";
		List<News> list = query(hql1, null, hql1, page);
		for (int i = 0; i < list.size(); i++) {
			Users user=(Users) get(Users.class, list.get(i).getUId());
			user.setUPass(null);
			list.get(i).setUser(user);
		}
		if (list.size()>0){
			respNewsAll.setData(list);
			respNewsAll.setResult("001");
		}else {
			respNewsAll.setData(null);
			respNewsAll.setResult("004");
		}
		}
		return respNewsAll;
	}



	@Override
	public RespNews findSingleNews(String NId) {
		RespNews respNews = new RespNews();
		if(NId==null||"".equals(NId)){
			respNews.setData(null);
			respNews.setResult("002");
		}else{
			News news = (News) get(News.class,NId);
			Users user=(Users) get(Users.class,news.getUId());
			user.setUPass(null);
			news.setUser(user);
			respNews.setData(news);
			respNews.setResult("001");
		}
		return respNews;
	}

	@Override
	public RespNews insertNews(String NTitle, String NContent, String NImgs,
			String NUrl, String NOrigin, String NType,String NIstop, String UId, String NStatus) {
	RespNews respNews = new RespNews();
	News news = new News();
	if (NTitle==null||"".equals(NTitle)){
		respNews.setData(null);
		respNews.setResult("002");
	} else if(NContent==null||"".equals(NContent)){
		respNews.setData(null);
		respNews.setResult("003");
		
	} else if(NOrigin==null||"".equals(NOrigin)){
		respNews.setData(null);
		respNews.setResult("004");
		
	} else if(NType==null||"".equals(NType)){
		respNews.setData(null);
		respNews.setResult("005");
		
	} else if(NIstop==null||"".equals(NIstop)){
		respNews.setData(null);
		respNews.setResult("006");
	} else if(UId==null||"".equals(UId)){
		respNews.setData(null);
		respNews.setResult("007");
	} else if(NStatus==null||"".equals(NStatus)){
		respNews.setData(null);
		respNews.setResult("008");
	} else{
	String time = getTime();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	Date datmp=new Date();
	try {
		datmp=sdf.parse(time);
	} catch (ParseException e1) {
		e1.printStackTrace();
	}
	NameOfDate nameOfData = new NameOfDate();
	String nId = nameOfData.getNum();
	
	news.setNId(nId);
	news.setNContent(NContent);
	news.setNCreatTime(datmp);
	news.setNFinalTime(datmp);
	news.setNImgs(NImgs);
	news.setNIstop(NIstop);
	news.setNOrigin(NOrigin);
	news.setNUrl(NUrl);
	news.setUId(UId);
	news.setNStatus(NStatus);
	news.setNTitle(NTitle);
	news.setNType(NType);
	save(news);
	
	respNews.setData(news);
	respNews.setResult("001");
	}
	return respNews;
	}

	@Override
	public RespNews upDateNews(String NId, String NTitle, String NContent,
			String NImgs, String NUrl, String NOrigin, String NType,
			String NCreatTime, String NFinalTime, String NIstop, String UId,
			String NStatus) {
		RespNews respNews = new RespNews();
		News news = new News();
		if (NTitle==null||"".equals(NTitle)){
			respNews.setData(null);
			respNews.setResult("002");
		} else if(NId==null||"".equals(NId)){
			respNews.setData(null);
			respNews.setResult("009");
			
		} else if(NFinalTime==null||"".equals(NFinalTime)){
			respNews.setData(null);
			respNews.setResult("010");
			
		} else if(NContent==null||"".equals(NContent)){
			respNews.setData(null);
			respNews.setResult("003");
			
		} else if(NOrigin==null||"".equals(NOrigin)){
			respNews.setData(null);
			respNews.setResult("004");
			
		} else if(NType==null||"".equals(NType)){
			respNews.setData(null);
			respNews.setResult("005");
			
		} else if(NIstop==null||"".equals(NIstop)){
			respNews.setData(null);
			respNews.setResult("006");
		} else if(UId==null||"".equals(UId)){
			respNews.setData(null);
			respNews.setResult("007");
		} else if(NStatus==null||"".equals(NStatus)){
			respNews.setData(null);
			respNews.setResult("008");
		} else{	
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date datmp=new Date();
			try {
				datmp=sdf.parse(NCreatTime);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			news.setNId(NId);
			news.setNContent(NContent);
			news.setNCreatTime(datmp);
			news.setNFinalTime(datmp);
			news.setNImgs(NImgs);
			news.setNIstop(NIstop);
			news.setNOrigin(NOrigin);
			news.setNUrl(NUrl);
			news.setUId(UId);
			news.setNStatus(NStatus);
			news.setNTitle(NTitle);
			news.setNType(NType);
			save(news);
			
			respNews.setData(news);
			respNews.setResult("001");
		}
		return respNews;
	}



	@Override
	public RespNewsAll findAllNewsOnByPage(String pageNo, String pageSize,
			String NStatus, String NIstop, String NFinalTime) {
		RespNewsAll respNewsAll = new RespNewsAll();
		int pano = Integer.valueOf(pageNo);
		int size = Integer.valueOf(pageSize);
		if (pano<=0) {
			respNewsAll.setResult("002");
			respNewsAll.setData(null);
		}else if (size<=0) {
			respNewsAll.setResult("003");
			respNewsAll.setData(null);
		}else if((NStatus!=null||!"".equals(NStatus))&&"1".equals(NStatus)){
			Page page=new Page(pano, 0, size);
			String hql1="from News where NStatus = "+NStatus+" order by NFinalTime desc ";
			List<News> list = query(hql1, null, hql1, page);
			for (int i = 0; i < list.size(); i++) {
				Users user=(Users) get(Users.class, list.get(i).getUId());
				user.setUPass(null);
				list.get(i).setUser(user);
			}
			if (list.size()>0){
				respNewsAll.setData(list);
				respNewsAll.setResult("001");
			}else {
				respNewsAll.setData(null);
				respNewsAll.setResult("004");
			}
		}else {
			respNewsAll.setData(null);
			respNewsAll.setResult("005");
		}
		return respNewsAll;
	}
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		return time;
	}



	@Override
	public List getUserals() {
		
		return find("from Users", null);
	}



	@Override
	public void initNews(News news) {
		//装填创建者用户
		if (news!=null) {
			Users users=(Users) get(Users.class, news.getUId());
			if (users!=null) {
				news.setUser(users);
			}
		}
	}



	@Override
	public void initNews(List<News> newslist) {
		if (newslist!=null) {
			for (int i = 0; i < newslist.size(); i++) {
				initNews(newslist.get(i));
			}
		}
		
	}
}
