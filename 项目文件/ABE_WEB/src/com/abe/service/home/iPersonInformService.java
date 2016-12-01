package com.abe.service.home;

import com.abe.entity.app.RespPersonInform;

/*
 * 个人通知
 * @author 李钊
 */
public interface iPersonInformService {
	/*
	 * 新建/发送通知
	 * @param PersonInform
	 */
	public RespPersonInform insertPersonInform();
	/*
	 * 删除通知
	 * 
	 */
	public RespPersonInform deletePersonInform();
	/*
	 * 查询通知
	 * 
	 */
	public RespPersonInform queryPersonInform();
}
