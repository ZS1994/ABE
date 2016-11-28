/**
 * 
 */
package com.abe.service.home.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.abe.entity.Card;
import com.abe.service.home.iCardService;
import com.abe.service.impl.BaseServiceImpl;

/**
 * @author 张顺
 *
 */
public class CardServiceImpl extends BaseServiceImpl implements iCardService{

	@Override
	public String add(String CId, String CType, String strId, String itId,String CState) {
		List list  = find("from Card where CId =? ", new String[]{CId});
		if(list.size()>0){
			Timestamp CCreateTime = new Timestamp(new Date().getTime());
			Card c = new Card(CId, CType, strId, itId, CCreateTime, CState);
			update(c);
		}else{
			Timestamp CCreateTime = new Timestamp(new Date().getTime()); 
			Card c = new Card(CId, CType, strId, itId, CCreateTime, CState);
			save(c);
		}
		return null;
	}

	@Override
	public List queryAll() {
		List<Card> list =  find ("from Card",null);
		return list;
	}


	@Override
	public Card queryOfId(String CId) {
		List<Card> list  = find("from Card Where CId = ?",new String[]{CId});
		if(list.size()>0){
			Card card = list.get(0);
			return card;
		}
		return null;
	}

}
