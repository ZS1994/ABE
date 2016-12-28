package com.abe.action.information;

import java.io.IOException;

import net.sf.json.JSONObject;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.Return;
import com.abe.entity.other.RespReturn;
import com.abe.entity.other.RespReturnAll;
import com.abe.service.iBaseService;
import com.abe.service.information.iReturnService;

public class ReturnAction extends BaseAction implements iBaseAction {
	private static final long serialVersionUID = 1L;

	private iBaseService ser;
	private iReturnService returnSer;
	private Return returns;

	public iBaseService getSer() {
		return ser;
	}

	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	public iReturnService getReturnSer() {
		return returnSer;
	}

	public void setReturnSer(iReturnService returnSer) {
		this.returnSer = returnSer;
	}

	public Return getReturns() {
		return returns;
	}

	public void setReturns(Return returns) {
		this.returns = returns;
	}

	public String insertReturn() throws IOException {
		String uId = (String) getRequest().getParameter("UId");
		String rContent = (String) getRequest().getParameter("RContent");
		RespReturn respReturn = returnSer.insertReturn(rContent, uId);
		sendToApp(respReturn, ser);
		return null;
	}

	public String findSingleReturn() throws IOException {
		String rId = (String) getRequest().getParameter("RId");
		RespReturn respReturn = returnSer.findSingleReturn(rId);
		sendToApp(respReturn, ser);
		return null;
	}

	public String updateReturn() throws IOException {
		String rId = (String) getRequest().getParameter("RId");
		String rStatus = (String) getRequest().getParameter("RStatus");
		RespReturn respReturn = returnSer.updateReturn(rId, rStatus);
		sendToApp(respReturn, ser);
		return null;
	}

	public String findAllReturnsByPage() throws IOException {
		String pageNo = (String) getRequest().getParameter("PageNo");
		String pageSize = (String) getRequest().getParameter("PageSize");
		String rStatus = (String) getRequest().getParameter("RStatus");
		RespReturnAll respReturnAll = returnSer.findAllReturnsByPage(pageNo, pageSize, rStatus);
		sendToApp(respReturnAll, ser);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

}
