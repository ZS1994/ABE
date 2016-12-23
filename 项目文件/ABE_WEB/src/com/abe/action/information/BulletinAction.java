package com.abe.action.information;

import java.io.IOException;

import net.sf.json.JSONObject;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.AllInform;
import com.abe.entity.other.RespBulletin;
import com.abe.entity.other.RespBulletinAll;
import com.abe.service.iBaseService;
import com.abe.service.information.iBulletinService;
import com.opensymphony.xwork2.ActionContext;

public class BulletinAction extends BaseAction implements iBaseAction {
	private static final long serialVersionUID = 1L;

	private iBaseService ser;
	private iBulletinService bulletinSer;
	private AllInform allInform;

	public iBaseService getSer() {
		return ser;
	}

	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	public iBulletinService getBulletinSer() {
		return bulletinSer;
	}

	public void setBulletinSer(iBulletinService bulletinSer) {
		this.bulletinSer = bulletinSer;
	}

	public AllInform getAllInform() {
		return allInform;
	}

	public void setAllInform(AllInform allInform) {
		this.allInform = allInform;
	}

	public String insertBulletin() throws IOException {
		String aiTitle = (String) getRequest().getParameter("AiTitle");
		String aiContent = (String) getRequest().getParameter("AiContent");
		String itId = (String) getRequest().getParameter("TrpId");
		RespBulletin respBulletin = bulletinSer.insertBulletin(aiTitle,
				aiContent, itId);
		JSONObject jsonObject = ser.objToJson(respBulletin,
				"yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}

	public String queryBulletinByItId() throws IOException {
		String pageNo = (String) getRequest().getParameter("pageNo");
		String pageSize = (String) getRequest().getParameter("pageSize");
		String itId = (String) getRequest().getParameter("TrpId");
		RespBulletinAll respBulletinAll = bulletinSer.queryBulletinByItId(
				pageNo, pageSize, itId);
		JSONObject jsonObject = ser.objToJson(respBulletinAll,
				"yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}

	public String findSingleBulletin() throws IOException {
		String aiId = (String) getRequest().getParameter("AiId");
		RespBulletin respBulletin = bulletinSer.findSingleBulletinById(aiId);
		JSONObject jsonObject = ser.objToJson(respBulletin,
				"yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
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
		String pageNo = (String) getRequest().getParameter("pageNo");
		String pageSize = "10";
		int record = ser.find("from PersonInform", null).size();
		int maxPage = (record - 1) / 10 + 1;
		int curPage = Integer.parseInt(pageNo);
		if (curPage < 1)
			curPage = 1;
		if (curPage > maxPage)
			curPage = maxPage;
		ActionContext.getContext().put("curPage", curPage);
		ActionContext.getContext().put("maxPage", maxPage);
		RespBulletinAll respBulletinAll = bulletinSer.queryBulletinByPage(
				curPage + "", pageSize);
		return "query";
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

}
