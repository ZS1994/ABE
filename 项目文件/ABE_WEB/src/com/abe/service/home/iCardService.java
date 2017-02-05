/**
 * 
 */
package com.abe.service.home;

import java.util.List;

import com.abe.entity.Card;
import com.abe.entity.InfoStudent;
import com.abe.entity.InfoTeacher;

/**
 * @author 张顺
 *<br/>卡片管理接口
 */
public interface iCardService {

	/**
	 *  2016年11月21日 
	 * <br/>添加卡片信息，和修改卡片信息都在此处理
	 * @author 张顺 
	 * @param CId CType strId itId CState
	 * @return
	 */
	public String add(String CId,String CType,String strId,String itId,String CState);
	
	
	
	/**
	 * 2016年11月24日
	 * <br/>查询所有卡片信息
	 * @author 张顺
	 * @return list
	 */
	public List queryAll();
	
	
	
	/**
	 * 2016年11月24日
	 * <br/>通过卡片id查询卡片信息
	 * @author 张顺
	 * @param CId
	 * @return Card
	 */
	public Card queryOfId(String CId);
	
	/*不用多说，获取所需信息*/
	public List<InfoStudent> getStus();
	
	public List<InfoTeacher> getTeas();
	
}
