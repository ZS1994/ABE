package com.abe.action.information;

import java.io.IOException;

import net.sf.json.JSONObject;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.ClassInform;
import com.abe.entity.other.RespBulletin;
import com.abe.entity.other.RespBulletinAll;
import com.abe.entity.other.RespClassInform;
import com.abe.entity.other.RespClassInformAll;
import com.abe.service.iBaseService;
import com.abe.service.information.iClassInformService;
import com.opensymphony.xwork2.ActionContext;

public class ClassInformAction extends BaseAction implements iBaseAction {
	private static final long serialVersionUID = 1L;

	private iBaseService ser;
	private iClassInformService classInformSer;
	private ClassInform classInform;
	public iBaseService getSer() {
		return ser;
	}

	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	public iClassInformService getClassInformSer() {
		return classInformSer;
	}

	public void setClassInformSer(iClassInformService classInformSer) {
		this.classInformSer = classInformSer;
	}

	public ClassInform getClassInform() {
		return classInform;
	}

	public void setClassInform(ClassInform classInform) {
		this.classInform = classInform;
	}

	public String insertClassInform() throws IOException {
		String ciTitle = (String) getRequest().getParameter("CiTitle");
		String ciContent = (String) getRequest().getParameter("CiContent");
		String scId = (String) getRequest().getParameter("ScId");
		String itId = (String) getRequest().getParameter("TrpId");
		RespClassInform respClassInform = classInformSer.insertClassInform(ciTitle, ciContent, scId, itId);
		sendToApp(respClassInform, ser);
		return null;
	}

	public String findClassInformByScId() throws IOException {
		String pageNo = (String) getRequest().getParameter("pageNo");
		String pageSize = (String) getRequest().getParameter("pageSize");
		String scId = (String) getRequest().getParameter("ScId");
		RespClassInformAll respClassInformAll = classInformSer.findClassInformByScId(pageNo, pageSize, scId);
		sendToApp(respClassInformAll, ser);
		return null;
	}

	public String findSingleClassInformById() throws IOException {
		String ciId = (String) getRequest().getParameter("CiId");
		RespClassInform respClassInform = classInformSer.findSingleClassInformById(ciId);
		sendToApp(respClassInform, ser);
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
		int record = ser.find("from ClassInform", null).size();
		int maxPage = (record - 1) / 10 + 1;
		int curPage = Integer.parseInt(pageNo);
		if (curPage < 1)
			curPage = 1;
		if (curPage > maxPage)
			curPage = maxPage;
		ActionContext.getContext().put("curPage", curPage);
		ActionContext.getContext().put("maxPage", maxPage);
		RespClassInformAll respClassInformAll = classInformSer.findClassInformByPage(
				curPage + "", pageSize);
		return "query";
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

}
