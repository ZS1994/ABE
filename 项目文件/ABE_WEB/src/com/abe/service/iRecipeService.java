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
	 * @param uId
	 */
	public RespRecipeAll findPageCreaterRecipe(String uId,String pageNo,String pageSize);
	/*
	 * 查询单个食谱
	 * @param rId
	 */
	public RespRecipe findSingleRecipe(String rId);
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
	public RespRecipe releaseRecipe(String rId,String scId, String rType, String rTime,
			String rState, String uId, String rImages, 
			String isIdAll,String rCreatTime,String rImagesUrl);
	/*
	 * 修改食谱
	 * @param Recipe
	 */
	public RespRecipe updateRecipe(String rId,String scId, String rType, String rTime,
			String rState, String uId, String rImages, 
			String isIdAll,String rStatus,String rCreatTime);
	/*
	 * 删除食谱
	 * @param Recipe
	 */
	public RespRecipe deleteRecipe(String rId);
}
