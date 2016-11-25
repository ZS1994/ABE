package com.abe.action.home;

import java.io.IOException;

import net.sf.json.JSONObject;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.News;
import com.abe.entity.app.RespNews;
import com.abe.entity.app.RespNewsAll;
import com.abe.entity.app.RespVacate;
import com.abe.service.iBaseService;
import com.abe.service.home.iNewsService;

public class NewsAction extends BaseAction implements iBaseAction {
	private static final long serialVersionUID = 1L;
	
	
	private iBaseService ser;
	private iNewsService newsSer;
	private News news;
	
	public String insertNews () throws IOException{
		String nTitle=(String) getRequest().getParameter("NTitle");
		String nContent=(String) getRequest().getParameter("NContent");
		String nImgs=(String) getRequest().getParameter("NImgs");
		String nUrl=(String) getRequest().getParameter("NUrl");
		String nOrigin=(String) getRequest().getParameter("NOrigin");
		String nType=(String) getRequest().getParameter("NType");
		String nIstop=(String) getRequest().getParameter("NIstop");
		String uId=(String) getRequest().getParameter("UId");
		String nStatus=(String) getRequest().getParameter("NStatus");
		RespNews respNews = newsSer.insertNews(nTitle, nContent, nImgs, nUrl, nOrigin,nType, nIstop, uId, nStatus);
		JSONObject jsonObject=ser.objToJson(respNews, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}
	public String updateNews () throws IOException{
		String nId=(String) getRequest().getParameter("NId");
		String nTitle=(String) getRequest().getParameter("NTitle");
		String nContent=(String) getRequest().getParameter("NContent");
		String nImgs=(String) getRequest().getParameter("NImgs");
		String nUrl=(String) getRequest().getParameter("NUrl");
		String nOrigin=(String) getRequest().getParameter("NOrigin");
		String nType=(String) getRequest().getParameter("NType");
		String nCreatTime=(String) getRequest().getParameter("NCreatTime");
		String nFinalTime=(String) getRequest().getParameter("NFinalTime");
		String nIstop=(String) getRequest().getParameter("NIstop");
		String uId=(String) getRequest().getParameter("UId");
		String nStatus=(String) getRequest().getParameter("NStatus");
		RespNews respNews = newsSer.upDateNews(nId,nTitle, nContent, nImgs, nUrl, nOrigin,nType,nCreatTime,nFinalTime, nIstop, uId, nStatus);
		JSONObject jsonObject=ser.objToJson(respNews, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}
	public String findSingleNews () throws IOException{
		String nId=(String) getRequest().getParameter("NId");
		RespNews respNews = newsSer.findSingleNews(nId);
		JSONObject jsonObject=ser.objToJson(respNews, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}
	public String findAllNewsByPage () throws IOException{
		String pageNo = (String) getRequest().getParameter("pageNo");
		String pageSize = (String) getRequest().getParameter("Size");
		RespNewsAll respNews = newsSer.findAllNewsByPage(pageNo, pageSize);
		JSONObject jsonObject=ser.objToJson(respNews, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}
	public String findAllNewsOnByPage () throws IOException{
		String pageNo = (String) getRequest().getParameter("pageNo");
		String pageSize = (String) getRequest().getParameter("Size");
		String nStatus=(String) getRequest().getParameter("NStatus");
		String nIstop=(String) getRequest().getParameter("NIstop");
		String nFinalTime=(String) getRequest().getParameter("NFinalTime");
		RespNewsAll respNews = newsSer.findAllNewsOnByPage(pageNo, pageSize, nStatus, nIstop, nFinalTime);
		JSONObject jsonObject=ser.objToJson(respNews, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public iBaseService getSer() {
		return ser;
	}

	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	public iNewsService getNewsSer() {
		return newsSer;
	}

	public void setNewsSer(iNewsService newsSer) {
		this.newsSer = newsSer;
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
