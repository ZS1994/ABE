package com.abe.action.home;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.InfoStudent;
import com.abe.entity.News;
import com.abe.entity.Users;
import com.abe.entity.other.RespNews;
import com.abe.entity.other.RespNewsAll;
import com.abe.entity.other.RespVacate;
import com.abe.service.iBaseService;
import com.abe.service.home.iNewsService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;
import com.opensymphony.xwork2.ActionContext;

public class NewsAction extends BaseAction implements iBaseAction {
	private static final long serialVersionUID = 1L;

	private iBaseService ser;
	private iNewsService newsSer;
	private News news;
	//-------------
	private List<News> newslist;
	private String result="news";
	private Page page;
	private String id;
	private String cz;
	
	public List<News> getNewslist() {
		return newslist;
	}
	public void setNewslist(List<News> newslist) {
		this.newslist = newslist;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
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
		sendToApp(respNews, ser);
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
		sendToApp(respNews, ser);
		return null;
	}

	public String findSingleNews() throws IOException {
		String nId = (String) getRequest().getParameter("NId");
		RespNews respNews = newsSer.findSingleNews(nId);
		sendToApp(respNews, ser);
		return null;
	}

	public String findAllNewsByPage() throws IOException {
		String pageNo = (String) getRequest().getParameter("pageNo");
		String pageSize = (String) getRequest().getParameter("Size");
		RespNewsAll respNews = newsSer.findAllNewsByPage(pageNo, pageSize);
		sendToApp(respNews, ser);
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
		sendToApp(respNews, ser);
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
		id=null;
		cz=null;
		news=null;
		newslist=null;

	}

	@Override
	public void clearSpace() {
		if (id!=null) {
			id=id.trim();
		}
		if (cz!=null) {
			cz=cz.trim();
		}

	}

	@Override
	public String delete() {
		clearSpace();
		if (id!=null) {
			news=(News) ser.get(News.class, id);
			if (news!=null) {
				ser.delete(news);
			}
		}
		return gotoQuery();
	}

	@Override
	public String gotoQuery() {
		clearOptions();
		if (page==null) {
			page=new Page(1, 0, 10);
		}else {
			page.setPageOn(1);
		}
		String hql=new String("from News order by NFinalTime desc");
		newslist = ser.query(hql,null,hql,page);
		newsSer.initNews(newslist);
		getRequest().setAttribute("userals", newsSer.getUserals());
		return result;
	}

	@Override
	public String queryOfFenYe() {
		clearSpace();
		if (cz!=null && cz.equals("yes")) {
			clearOptions();
		}
		if (page==null) {
			page=new Page(1, 0, 10);
		}
		StringBuffer hql=new StringBuffer("from News where 1=1 ");
		if (id!=null) {
			hql.append("and NId like '%"+id+"%' ");
		}
		hql.append("order by NFinalTime desc");
		newslist = ser.query(hql.toString(), null, hql.toString(), page);
		newsSer.initNews(newslist);
		getRequest().setAttribute("userals", newsSer.getUserals());
		return result;
	}

	@Override
	public String update() {
		clearSpace();
		if (news!=null) 
		 {
			news.setNFinalTime(getTime());
			ser.update(news);
		}
		return gotoQuery();
	}

	public static Date getTime() {
		Timestamp time = new Timestamp(new Date().getTime());
		return time;
	}

}
