package com.abe.service.home;

import java.util.List;

import com.abe.entity.InfoParents;
import com.abe.entity.app.RespCommon;

public interface iParentService {
	
	/**
	 * 张顺 2016-12-1
	 * 得到所有的家长档案信息
	 * @return
	 */
	public List<InfoParents> getAllParents();

	
	/**
	 * 从APP添加家长档案
	 */
	public RespCommon addFromApp(InfoParents parent,String code);
	
	
	/**
	 * 获取验证码
	 */
	public RespCommon getCode();
	
}
