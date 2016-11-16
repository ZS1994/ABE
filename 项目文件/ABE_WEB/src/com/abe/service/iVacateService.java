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
	public RespVacate createVacate();
	/*
	 * 批复请假条
	 */
	public RespVacate respsVacate();
	/*
	 * 查看请假条
	 */
	public RespVacateAll findVacate();
}
