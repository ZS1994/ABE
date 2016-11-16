package com.abe.service;

import com.abe.entity.app.RespRecipe;
import com.abe.entity.app.RespRecipeAll;

/**
 * 食谱模块
 * @author 李钊
 */
public interface iRecipeService {

	/*
	 * 查询所有食谱
	 */
	public RespRecipeAll findPageAllRecipe();
	/*
	 * 根据创建者查询食谱
	 */
	public RespRecipeAll findPageCreaterRecipe(String uid);
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
	/*
	 * 修改食谱
	 * @param Recipe
	 */
	public RespRecipe upDateRecipe(String scId, String rType, String rTime,
			String rState, String uId, String rImages, 
			String isIdAll);
	/*
	 * 删除食谱
	 * @param Recipe
	 */
	public RespRecipe deleteRecipe(String rId);
}
