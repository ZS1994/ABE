package com.abe.service.home.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.abe.entity.News;
import com.abe.entity.Vacate;
import com.abe.entity.app.RespNews;
import com.abe.entity.app.RespNewsAll;
import com.abe.entity.app.RespVacate;
import com.abe.service.home.iNewsService;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.tools.NameOfDate;

public class NewsServiceImpl extends BaseServiceImpl implements iNewsService {

	@Override
	public RespNewsAll findAllNewsByPage(String pageNo, String pageSize) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public RespNews findSingleNews(String NId) {
		News news = (News) get(Vacate.class,NId);
		RespNews respNews = new RespNews("001",news);
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
	NameOfDate nameOfData = new NameOfDate();
	String nId = nameOfData.getNum();
	
	news.setNId(nId);
	news.setNContent(NContent);
	news.setNCreatTime(time);
	news.setNFinalTime(time);
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
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public RespNewsAll findAllNewsOnByPage(String pageNo, String pageSize,
			String NStatus, String NIstop, String NFinalTime) {
		// TODO Auto-generated method stub
		return null;
	}
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		return time;
	}
}
