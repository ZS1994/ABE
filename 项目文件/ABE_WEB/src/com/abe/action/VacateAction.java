package com.abe.action;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.abe.entity.InfoStudent;
import com.abe.entity.SchoolClass;
import com.abe.entity.Vacate;
import com.abe.entity.other.RespRecipeAll;
import com.abe.entity.other.RespVacate;
import com.abe.entity.other.RespVacateAll;
import com.abe.service.iBaseService;
import com.abe.service.iVacateService;

public class VacateAction extends BaseAction implements iBaseAction {
	private static final long serialVersionUID = 1L;

	private iBaseService ser;
	private iVacateService vacateSer;
	private Vacate vacate;
	
	/**
	 * 创建请假条
	 * @author 李钊
	 */	
	public String createVacate () throws IOException{
		String isId=(String) getRequest().getParameter("IsId");
		String uId=(String) getRequest().getParameter("UId");
		String vContent=(String) getRequest().getParameter("VContent");
		String vDate=(String) getRequest().getParameter("VDate");
		InfoStudent is = (InfoStudent) ser.get(InfoStudent.class, isId);
		SchoolClass sc = (SchoolClass) ser.get(SchoolClass.class,is.getScId());
		String itId = sc.getItId();
		RespVacate respVacate = vacateSer.createVacate(isId, uId, itId, vContent, vDate);
		sendToApp(respVacate, ser);
		return null;
	}
	/*
	 * 查询单条请假条
	 */	
	public String findSingleVacate () throws IOException{
		String vId=(String) getRequest().getParameter("VId");
		RespVacate respVacate = vacateSer.findSingleVacate(vId);
		sendToApp(respVacate, ser);
		return null;
	}
	/*
	 * 批复请假条
	 */
	public String respsVacate () throws IOException{
		String vId=(String) getRequest().getParameter("VId");
		String isId=(String) getRequest().getParameter("IsId");
		String uId=(String) getRequest().getParameter("UId");
		String itId=(String) getRequest().getParameter("ItId");
		String vContent=(String) getRequest().getParameter("VContent");
		String vDate=(String) getRequest().getParameter("VDate");
		String vResp=(String) getRequest().getParameter("VResp");
		String vTime=(String) getRequest().getParameter("VTime");
		RespVacate respVacate = vacateSer.respsVacate(vId, isId, uId, itId, vContent, vDate, vResp,vTime);
		sendToApp(respVacate, ser);
		return null;
	}
	/*
	 * 分页查看给该班主任/学生的请假条
	 */	
	public String findOwnerVacate () throws IOException{
		String uId=(String) getRequest().getParameter("UId");
		String pageNo = (String) getRequest().getParameter("pageNo");
		String pageSize = (String) getRequest().getParameter("Size");
		RespVacateAll respVacateAll = vacateSer.findOwnerVacate(uId,pageNo,pageSize);
		sendToApp(respVacateAll, ser);
		return null;
	}
	/*
	 * 分页查看所有请假条（是否分区域看后期需求）
	 */
	public String findAllVacate()throws IOException{
		String pageNo = (String) getRequest().getParameter("pageNo");
		String pageSize = (String) getRequest().getParameter("Size");
		RespVacateAll respVacateAll = vacateSer.findAllVacate(pageNo,pageSize);
		sendToApp(respVacateAll, ser);
		return null;
	}
	public Vacate getVacate() {
		return vacate;
	}
	
	public void setVacate(Vacate vacate) {
		this.vacate = vacate;
	}
	
	public iBaseService getSer() {
		return ser;
	}

	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	public iVacateService getVacateSer() {
		return vacateSer;
	}

	public void setVacateSer(iVacateService vacateSer) {
		this.vacateSer = vacateSer;
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
