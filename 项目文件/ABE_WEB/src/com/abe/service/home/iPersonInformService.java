package com.abe.service.home;

import com.abe.entity.other.RespPersonInform;
import com.abe.entity.other.RespPersonInformAll;

/*
 * 个人通知
 * @author 李钊
 */
public interface iPersonInformService {
	/*
	 * 新建/发送通知
	 * @param PersonInform
	 */
	public RespPersonInform insertPersonInform(String piTitle,String piContent,String uId);
	/*
	 * 删除通知
	 * 
	 */
	public RespPersonInform deletePersonInform();
	/*
	 * 根据用户ID分页查询通知
	 * 
	 */
	public RespPersonInformAll queryPersonInformByUId(String pageNo,String pageSize,String uId);
	/*
	 * 手机端查询单条通知（将会更改状态为已读）
	 * 
	 */
	public RespPersonInform findSinglePersonInform(String piId);
	/*
	 * web端无条件分页查询所有通知
	 * 
	 */
	public RespPersonInformAll findByPage(String pageNo,String pageSize);
}
