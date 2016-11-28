/**
 * 
 */
package com.abe.action.home;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.Card;
import com.abe.service.iBaseService;
import com.abe.service.home.iCardService;

/**
 * 张顺   2016年11月24日
 * <br/> 卡片管理
 * 
 * @author 张顺
 *
 */
public class CardAction extends BaseAction implements iBaseAction{

	private iBaseService ser;
	private iCardService cardSer;
	
	private Card card;
	
	private String result="card";
	private String result_fail="";
	
	
	
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public iBaseService getSer() {
		return ser;
	}

	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	public iCardService getCardSer() {
		return cardSer;
	}

	public void setCardSer(iCardService cardSer) {
		this.cardSer = cardSer;
	}

	@Override
	public String add() {
		cardSer.add(card.getCId(), card.getCType(), card.getSrtId(), card.getItId(), card.getCState());
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
		return result;
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
