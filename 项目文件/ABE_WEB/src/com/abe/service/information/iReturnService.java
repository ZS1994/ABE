package com.abe.service.information;

import java.util.List;

import com.abe.entity.Return;
import com.abe.entity.other.RespReturn;
import com.abe.entity.other.RespReturnAll;

/*
 * 用户反馈
 * @author 李钊
 */
public interface iReturnService {
	/*
	 * 用户建立反馈
	 */
	public RespReturn insertReturn(String rContent,String uId);
	/*
	 * 查看单条反馈
	 */
	public RespReturn findSingleReturn(String rId);
	/*
	 * 修改反馈状态
	 */
	public RespReturn updateReturn(String rId,String rStatus);
	/*
	 * 分页查看所有反馈
	 */
	public RespReturnAll findAllReturnsByPage(String pageNo,String pageSize,String rStatus);
	public void initRet(List<Return> rets);
	public void initRet(Return ret);
}
