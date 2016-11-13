package com.abe.service;

import com.abe.entity.app.RespRecipe;

/**
 * 食谱模块
 * @author 李钊
 */
public interface iRecipeService {

	/*
	 * 查询所有食谱
	 */
	public RespRecipe findAllRecipe();
	/*
	 * 创建食谱
	 * @param Recipe
	 * 
	 */
	public RespRecipe creatRecipe(String scId, String rType, String rTime,
			String rState, String uId, String rImages,
			String isIdAll);
	/**
	 * 发布食谱
	 * @param Recipe
	 */
	public RespRecipe releaseRecipe(String scId, String rType, String rTime,
			String rState, String uId, String rImages, 
			String isIdAll);
}
