package com.abe.action.information;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONObject;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.InfoStudent;
import com.abe.entity.Return;
import com.abe.entity.other.RespReturn;
import com.abe.entity.other.RespReturnAll;
import com.abe.service.iBaseService;
import com.abe.service.information.iReturnService;
import com.abe.tools.Page;

public class ReturnAction extends BaseAction implements iBaseAction {
	private static final long serialVersionUID = 1L;

	private iBaseService ser;
	private iReturnService returnSer;
	private Return returns;

	private String result="returns";
	private List<Return> rets;
	private Page page;
	private String id;
	private String cz;
	
	public List<Return> getRets() {
		return rets;
	}

	public void setRets(List<Return> rets) {
		this.rets = rets;
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
		rets=null;
		returns=null;
		id=null;
		cz=null;
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
			returns=(Return) ser.get(Return.class, id);
			if (returns!=null) {
				ser.delete(returns);
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
		String hql="from Return order by RTime desc";
		rets=ser.query(hql, null, hql, page);
		returnSer.initRet(rets);//装填封装
		return result;
	}

	@Override
	public String queryOfFenYe() {
		clearSpace();
		clearOptions();
		if (cz!=null && cz.equals("yes")) {
			clearOptions();
		}
		if (page==null) {
			page=new Page(1, 0, 10);
		}
		StringBuffer hql=new StringBuffer("from Return where 1=1 ");
		if (id!=null) {
			hql.append("and RId like '%"+id+"%' ");
		}
		hql.append("order by RTime desc");
		rets=ser.query(hql.toString(), null, hql.toString(), page);
		returnSer.initRet(rets);
		return result;
	}

	@Override
	public String update() {
		clearSpace();
		if (returns!=null) {
			ser.update(returns);
		}
		
		return gotoQuery();
	}

}
