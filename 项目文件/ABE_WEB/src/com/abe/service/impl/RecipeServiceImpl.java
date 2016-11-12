package com.abe.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.abe.entity.Recipe;
import com.abe.entity.app.RespRecipe;
import com.abe.service.iRecipeService;
import com.abe.tools.NameOfDate;


public class RecipeServiceImpl extends BaseServiceImpl implements iRecipeService {

	
	@Override
	public RespRecipe creatRecipe(String scId, String rType, String rTime,
			String rState, String uId, String rImages,
			String isIdAll) {
		final String HINT_SUCCESS_RECIPE = "001";//创建食谱成功
		
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
		save(recipe);
		respRecipe.setResult(HINT_SUCCESS_RECIPE);
		respRecipe.setData(recipe);
		return respRecipe;
	}
	@Override
	public RespRecipe releaseRecipe(String scId, String rType, String rTime,
			String rState, String uId, String rImages, String isIdAccept,
			String isIdAll) {
		
		return null;
	}
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(new Date());
		return time;
	}

}
