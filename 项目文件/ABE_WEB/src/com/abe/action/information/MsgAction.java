package com.abe.action.information;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.service.iBaseService;
import com.abe.service.hx.iMessageService;

/**
 * 发送消息：单人、群发、聊天室、群组。。。
 * @author 张顺
 */
public class MsgAction extends BaseAction implements iBaseAction{
	
	private iBaseService ser;
	private iMessageService msgSer;
	
	
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
		//接受消息
		String target=ser.clearSpace(getRequest(), "target");
		String from=ser.clearSpace(getRequest(), "from");
		String msg=ser.clearSpace(getRequest(), "msg");
		msgSer.sengMsgOne(target, from, msg);
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
