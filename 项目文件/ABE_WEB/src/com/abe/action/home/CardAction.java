/**
 * 
 */
package com.abe.action.home;

import java.util.List;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.Card;
import com.abe.entity.InfoTeacher;
import com.abe.entity.SchoolGrade;
import com.abe.service.iBaseService;
import com.abe.service.home.iCardService;
import com.abe.tools.Page;

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
	private List<Card> cards;
	private String result="card";
	private Page page;
	private String cz=null;
	private String id=null;
	
	
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	//---------------------------------------------------
	
	@Override
	public void clearOptions() {
		card=null;
		cards=null;
		id=null;
		cz=null;
	}
	
	@Override
	public void clearSpace() {
		if(id!=null){
			id=id.trim();
		}
		if(cz!=null){
			cz=cz.trim();
		}
	}
	
	@Override
	public String add() {
		clearSpace();
		if (card!=null) {
			cardSer.add(card.getCId(), card.getCType(), card.getSrtId(), card.getItId(), card.getCState());
		}
		return gotoQuery();
	}
	
	@Override
	public String delete() {
		clearSpace();
		if (id!=null) {
			card=(Card) ser.get(Card.class, id);
			if (card!=null) 
				ser.delete(card);
		}
		return gotoQuery();
	}

	@Override
	public String gotoQuery() {
		clearOptions();
		if (page!=null) {
			page.setPageOn(1);
		}else {
			page=new Page(1, 0, 10);
		}
		String hql="from Card order by CCreateTime desc";
		cards=ser.query(hql, null, hql, page);
		getRequest().setAttribute("stus", cardSer.getStus());
		getRequest().setAttribute("teas", cardSer.getTeas());
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
		StringBuffer hql=new StringBuffer("from Card where 1=1 ");
		if (id!=null) {
			hql.append("and CId like '%"+id+"%' ");
		}
		hql.append("order by CCreateTime desc");
		cards=ser.query(hql.toString(), null, hql.toString(), page);
		getRequest().setAttribute("stus", cardSer.getStus());
		getRequest().setAttribute("teas", cardSer.getTeas());
		return result;
	}

	@Override
	public String update() {
		clearSpace();
		if (card!=null) {
			ser.update(card);
		}
		return gotoQuery();
	}

}
