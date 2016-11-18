package com.abe.service;

import com.abe.entity.app.RespVacate;
import com.abe.entity.app.RespVacateAll;

/**
 * 请假模块
 * @author 李钊
 */
public interface iVacateService {
	
	/*
	 * 写请假条
	 */
	public RespVacate createVacate(String isId,String uId,String itId,String vContent,String vDate);
	/*
	 * 批复请假条
	 */
	public RespVacate respsVacate(String vId,String isId,String uId,String itId,String vContent,String vDate,String vResp,String vTime);
	/*
	 * 查看单条请假条
	 */
	public RespVacate findSingleVacate(String vId);
	/*
	 * 分页查看给该班主任/学生的请假条
	 */
	public RespVacateAll findOwnerVacate(String uId,String pageNo,String pageSize);
	/*
	 * 分页查看所有请假条（是否分区域看后期需求）
	 */
	public RespVacateAll findAllVacate(String pageNo,String pageSize);

}
