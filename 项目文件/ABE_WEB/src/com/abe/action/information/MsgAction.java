package com.abe.action.information;

import java.io.IOException;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.other.RespCity;
import com.abe.entity.other.RespCommon;
import com.abe.service.iBaseService;
import com.abe.service.hx.iMessageService;

/**
 * 发送消息：单人、群发、聊天室、群组。。。
 * @author 张顺
 */
public class MsgAction extends BaseAction implements iBaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private iBaseService ser;
	private iMessageService msgSer;
	private Logger logger=Logger.getLogger(MsgAction.class);
	
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	public iMessageService getMsgSer() {
		return msgSer;
	}
	public void setMsgSer(iMessageService msgSer) {
		this.msgSer = msgSer;
	}
	
	/**
	 * 给一个人发送消息
	 * @return
	 */
	public String addFromApp() {
		//声明一个返回体备用
		RespCommon respResult=new RespCommon();
		//接受消息
		String target=ser.clearSpace(getRequest(), "target");
		String from=ser.clearSpace(getRequest(), "from");
		String msg=ser.clearSpace(getRequest(), "msg");
		String result=msgSer.sengMsgOne(target, from, msg);
		JSONObject jsonObj=ser.objToJson(result);
		String iSucc=(String) jsonObj.getJSONObject("data").get(target);
		if (iSucc.equals("success")) {
			respResult.setResult("001");
			respResult.setData(null);
		}else {
			respResult.setResult("002");
			respResult.setData(null);
		}
		sendToApp(respResult,ser);
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
