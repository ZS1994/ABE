package com.abe.action.home;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.News;
import com.abe.entity.Users;
import com.abe.entity.app.RespNews;
import com.abe.entity.app.RespNewsAll;
import com.abe.entity.app.RespVacate;
import com.abe.service.iBaseService;
import com.abe.service.home.iNewsService;
import com.abe.tools.NameOfDate;
import com.opensymphony.xwork2.ActionContext;

public class NewsAction extends BaseAction implements iBaseAction {
	private static final long serialVersionUID = 1L;

	private iBaseService ser;
	private iNewsService newsSer;
	private News news;

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

	public String insertNews() throws IOException {
		String nTitle = (String) getRequest().getParameter("NTitle");
		String nContent = (String) getRequest().getParameter("NContent");
		String nImgs = (String) getRequest().getParameter("NImgs");
		String nUrl = (String) getRequest().getParameter("NUrl");
		String nOrigin = (String) getRequest().getParameter("NOrigin");
		String nType = (String) getRequest().getParameter("NType");
		String nIstop = (String) getRequest().getParameter("NIstop");
		String uId = (String) getRequest().getParameter("UId");
		String nStatus = (String) getRequest().getParameter("NStatus");
		RespNews respNews = newsSer.insertNews(nTitle, nContent, nImgs, nUrl,
				nOrigin, nType, nIstop, uId, nStatus);
		JSONObject jsonObject = ser.objToJson(respNews, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}

	public String updateNews() throws IOException {
		String nId = (String) getRequest().getParameter("NId");
		String nTitle = (String) getRequest().getParameter("NTitle");
		String nContent = (String) getRequest().getParameter("NContent");
		String nImgs = (String) getRequest().getParameter("NImgs");
		String nUrl = (String) getRequest().getParameter("NUrl");
		String nOrigin = (String) getRequest().getParameter("NOrigin");
		String nType = (String) getRequest().getParameter("NType");
		String nCreatTime = (String) getRequest().getParameter("NCreatTime");
		String nFinalTime = (String) getRequest().getParameter("NFinalTime");
		String nIstop = (String) getRequest().getParameter("NIstop");
		String uId = (String) getRequest().getParameter("UId");
		String nStatus = (String) getRequest().getParameter("NStatus");
		RespNews respNews = newsSer.upDateNews(nId, nTitle, nContent, nImgs,
				nUrl, nOrigin, nType, nCreatTime, nFinalTime, nIstop, uId,
				nStatus);
		JSONObject jsonObject = ser.objToJson(respNews, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}

	public String findSingleNews() throws IOException {
		String nId = (String) getRequest().getParameter("NId");
		RespNews respNews = newsSer.findSingleNews(nId);
		JSONObject jsonObject = ser.objToJson(respNews, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}

	public String findAllNewsByPage() throws IOException {
		String pageNo = (String) getRequest().getParameter("pageNo");
		String pageSize = (String) getRequest().getParameter("Size");
		RespNewsAll respNews = newsSer.findAllNewsByPage(pageNo, pageSize);
		JSONObject jsonObject = ser.objToJson(respNews, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}

	public String findAllNewsOnByPage() throws IOException {
		String pageNo = (String) getRequest().getParameter("pageNo");
		String pageSize = (String) getRequest().getParameter("Size");
		String nStatus = (String) getRequest().getParameter("NStatus");
		String nIstop = (String) getRequest().getParameter("NIstop");
		String nFinalTime = (String) getRequest().getParameter("NFinalTime");
		RespNewsAll respNews = newsSer.findAllNewsOnByPage(pageNo, pageSize,
				nStatus, nIstop, nFinalTime);
		JSONObject jsonObject = ser.objToJson(respNews, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}
	@Override
	public String add() {
		news.setNId(NameOfDate.getNum());
		news.setNCreatTime(getTime());
		news.setNFinalTime(getTime());
		news.setNStatus("1");
		Users user = (Users) getRequest().getSession().getAttribute("user");
		news.setUId(user.getUId());
		/*
		 * String content = news.getNContent(); String imgs = ""; String
		 * hostPath = ""; String arr[] = news.getNContent().split("src=\"");
		 * String url = ""; String saveurl = ""; if (arr.length > 1) { for (int
		 * i = 1; i < arr.length; i += 2) { int count = arr[i].indexOf("\""); if
		 * (count >= 0) { url = arr[i].substring(0, count); // 服务器下载图片 saveurl =
		 * GetImage.putImage(url, homepath); content = content.replace(url,
		 * ippath + saveurl); imgs = imgs + ippath + saveurl + ";"; hostPath =
		 * hostPath + homepath + saveurl + ";"; } } content =
		 * content.replace("<img", "<img style=\"height:30%;width:100%;\"");
		 * news.setNContent(content); } news.setNImgs(imgs);
		 * news.setNUrl(hostPath);
		 */
		ser.save(news);

		return gotoQuery();
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
		String pageNo = "1";
		String pageSize = "10";
		RespNewsAll respNews = newsSer.findAllNewsByPage(pageNo, pageSize);
		List<News> list = respNews.getData();
		ActionContext.getContext().getApplication().put("data", list);
		return "query";
	}

	@Override
	public String queryOfFenYe() {
		String pageNo = (String) getRequest().getParameter("pageNo");
		String pageSize = "10";
		int record = ser.find("from News", null).size();
		int maxPage = (record - 1) / 10 + 1;
		int curPage = Integer.parseInt(pageNo);
		if (curPage < 1)
			curPage = 1;
		if (curPage > maxPage)
			curPage = maxPage;
		ActionContext.getContext().put("curPage", curPage);
		ActionContext.getContext().put("maxPage", maxPage);
		RespNewsAll respNews = newsSer.findAllNewsByPage(String.valueOf(curPage), pageSize);
		List<News> list = respNews.getData();
		ActionContext.getContext().getApplication().put("datas", list);
		return "query";
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		return time;
	}

}
