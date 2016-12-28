package com.abe.action.home;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONObject;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.PersonInform;
import com.abe.entity.other.RespPersonInform;
import com.abe.entity.other.RespPersonInformAll;
import com.abe.service.iBaseService;
import com.abe.service.home.iPersonInformService;
import com.opensymphony.xwork2.ActionContext;

public class PersonInformAction extends BaseAction implements iBaseAction {
	private static final long serialVersionUID = 1L;

	private iBaseService ser;
	private iPersonInformService personInformSer;
	private PersonInform personInform;
	
	public iBaseService getSer() {
		return ser;
	}

	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	public iPersonInformService getPersonInformSer() {
		return personInformSer;
	}

	public void setPersonInformSer(iPersonInformService personInformSer) {
		this.personInformSer = personInformSer;
	}

	public PersonInform getPersonInform() {
		return personInform;
	}

	public void setPersonInform(PersonInform personInform) {
		this.personInform = personInform;
	}

	public String insertPersonInform() throws IOException {
		String piTitle = (String) getRequest().getParameter("PiTitle");
		String piContent = (String) getRequest().getParameter("PiContent");
		String uId = (String) getRequest().getParameter("UId");
		RespPersonInform respPersonInform = personInformSer.insertPersonInform(piTitle,piContent,uId);
		sendToApp(respPersonInform, ser);

		return null;
	}
	public String queryPersonInformByUId()throws IOException {
		String pageNo = (String) getRequest().getParameter("pageNo");
		String pageSize = (String) getRequest().getParameter("pageSize");
		String uId = (String) getRequest().getParameter("UId");
		RespPersonInformAll respPersonInformAll = personInformSer.queryPersonInformByUId(pageNo,pageSize,uId);
		sendToApp(respPersonInformAll, ser);

		return null;
	}
	public String findSinglePersonInform () throws IOException{
		String piId=(String) getRequest().getParameter("PiId");
		RespPersonInform respPersonInform = personInformSer.findSinglePersonInform(piId);
		sendToApp(respPersonInform, ser);
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
		RespPersonInformAll respPersonInformAll = personInformSer.findByPage(String.valueOf(curPage), pageSize);
		List<PersonInform> list = respPersonInformAll.getData();
		ActionContext.getContext().getApplication().put("datas", list);
		return "query";
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

}
