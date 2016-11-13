package com.abe.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.abe.entity.Recipe;
import com.abe.entity.app.RespRecipe;
import com.abe.service.iRecipeService;
import com.abe.tools.NameOfDate;


public class RecipeServiceImpl extends BaseServiceImpl implements iRecipeService {

	
	@Override
	public RespRecipe creatRecipe(String scId, String rType, String rTime,
			String rState, String uId, String rImages,//images多张上传暂未解决
			String isIdAll) {
		final String HINT_SUCCESS_RECIPE = "001";//创建食谱成功
		final String HINT_STATUS_RECIPE = "未发布";
		
		RespRecipe respRecipe = new RespRecipe();
		Recipe recipe = new Recipe();
		NameOfDate nameOfData = new NameOfDate();
		
		String time = getTime();
		
		recipe.setRCreatTime(time);
		recipe.setRId(nameOfData.getNum());
		recipe.setScId(scId);
		recipe.setRType(rType);
		recipe.setRTime(rTime);
		recipe.setRState(rState);
		recipe.setUId(uId);
		recipe.setIsIdAll(isIdAll);
		recipe.setRStatus(HINT_STATUS_RECIPE);
		save(recipe);
		respRecipe.setResult(HINT_SUCCESS_RECIPE);
		respRecipe.setData(recipe);
		return respRecipe;
	}
	@Override
	public RespRecipe releaseRecipe(String scId, String rType, String rTime,
			String rState, String uId, String rImages,
			String isIdAll) {
		final String HINT_SUCCESS_RECIPE = "003";//发布食谱成功
		final String HINT_STATUS_RECIPE = "已发布";
		
		RespRecipe respRecipe = new RespRecipe();
		Recipe recipe = new Recipe();
		
		recipe.setScId(scId);
		recipe.setRType(rType);
		recipe.setRTime(rTime);
		recipe.setRState(rState);
		recipe.setUId(uId);
		recipe.setIsIdAll(isIdAll);
		recipe.setRStatus(HINT_STATUS_RECIPE);
		update(recipe);
		
		respRecipe.setResult(HINT_SUCCESS_RECIPE);
		respRecipe.setData(recipe);
		return respRecipe;
	}
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		return time;
	}
	@Override
	public RespRecipe findAllRecipe() {
		RespRecipe respRecipe = new RespRecipe();
		Recipe recipe = new Recipe();
		
		List<Recipe> list = find("from Recipe",null);
		if (list.size()>0){
			for (int i = 0; i < list.size(); i++){
				respRecipe.setData(list.get(i));
			}
		}
		return null;
	}

}
