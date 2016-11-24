package com.abe.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.abe.entity.Recipe;
import com.abe.entity.Users;
import com.abe.entity.app.RespRecipe;
import com.abe.entity.app.RespRecipeAll;
import com.abe.service.iRecipeService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;


public class RecipeServiceImpl extends BaseServiceImpl implements iRecipeService {

	
	@Override
	public RespRecipe creatRecipe(String scId, String rType, String rTime,
			String rState, String uId, String rImages,String rImagesUrl,//images多张上传暂未解决
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
	public RespRecipe releaseRecipe(String rId,String scId, String rType, String rTime,
			String rState, String uId, String rImages,
			String isIdAll,String rCreatTime,String rImagesUrl) {
		final String HINT_SUCCESS_RECIPE = "001";//发布食谱成功
		final String HINT_STATUS_RECIPE = "已发布";
		
		RespRecipe respRecipe = new RespRecipe();
		Recipe recipe = new Recipe();
		
		recipe.setRId(rId);
		recipe.setScId(scId);
		recipe.setRType(rType);
		recipe.setRTime(rTime);
		recipe.setRState(rState);
		recipe.setUId(uId);
		recipe.setIsIdAll(isIdAll);
		recipe.setRImages(rImages);
		recipe.setRImagesUrl(rImagesUrl);
		recipe.setRStatus(HINT_STATUS_RECIPE);
		recipe.setRCreatTime(rCreatTime);
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
	public RespRecipeAll findPageAllRecipe(String pageNo,String pageSize) {
		RespRecipeAll respRecipeAll = new RespRecipeAll();
		Recipe recipe = new Recipe();
		int pano = Integer.valueOf(pageNo);
		int size = Integer.valueOf(pageSize);
		if (pano<=0) {
			respRecipeAll.setResult("002");
			respRecipeAll.setData(null);
		}else if (size<=0) {
			respRecipeAll.setResult("003");
			respRecipeAll.setData(null);
		}else {
			Page page=new Page(pano, 0, size);
		String hql1="from Recipe  order by RCreatTime desc";
		List<Recipe> list = query(hql1, null, hql1, page);
		for (int i = 0; i < list.size(); i++) {
			Users user=(Users) get(Users.class, list.get(i).getUId());
			user.setUPass(null);
			list.get(i).setUsers(user);
		}
		if (list.size()>0){
			respRecipeAll.setData(list);
			respRecipeAll.setResult("001");
		}else {
			respRecipeAll.setData(null);
			respRecipeAll.setResult("004");
		}
		}
		return respRecipeAll;
	}
	@Override
	public RespRecipe updateRecipe(String rId,String scId, String rType, String rTime,
			String rState, String uId, String rImages,String rImagesUrl, String isIdAll,String rStatus,String rCreatTime) {
		RespRecipe respRecipe = new RespRecipe();
		Recipe recipe = new Recipe();
		recipe.setRId(rId);
		recipe.setScId(scId);
		recipe.setRType(rType);
		recipe.setRTime(rTime);
		recipe.setRState(rState);
		recipe.setUId(uId);
		recipe.setIsIdAll(isIdAll);
		recipe.setRImages(rImages);
		recipe.setRImagesUrl(rImagesUrl);
		recipe.setRStatus(rStatus);
		recipe.setRCreatTime(rCreatTime);
		update(recipe);
		
		respRecipe.setResult("001");
		respRecipe.setData(recipe);
		return respRecipe;
	}
	@Override
	public RespRecipe deleteRecipe(String rId) {
		Recipe recipe = (Recipe) get(Recipe.class,rId);
		delete(recipe);
		RespRecipe respRecipe = new RespRecipe("001",recipe);
		
		return respRecipe;
	}
	@Override
	public RespRecipeAll findPageCreaterRecipe(String uId,String pageNo,String pageSize) {
		RespRecipeAll respRecipeAll = new RespRecipeAll();
		Recipe recipe = new Recipe();		
		int pano = Integer.valueOf(pageNo);
		int size = Integer.valueOf(pageSize);
		if (pano<=0) {
			respRecipeAll.setResult("002");
			respRecipeAll.setData(null);
		}else if (size<=0) {
			respRecipeAll.setResult("003");
			respRecipeAll.setData(null);
		}else {
			Page page=new Page(pano, 0, size);
		String hql1="from Recipe where UId = ? order by RCreatTime";
		String hql2="from Recipe where UId = '"+uId+"' order by RCreatTime";
	List<Recipe> list = query(hql1, new String[]{uId}, hql2, page);
//			List<Recipe> list = find("from Recipe",null);
		for (int i = 0; i < list.size(); i++) {
			Users user=(Users) get(Users.class, list.get(i).getUId());
			user.setUPass(null);
			list.get(i).setUsers(user);
		}
		if (list.size()>0){
			respRecipeAll.setData(list);
			respRecipeAll.setResult("001");
		}else {
			respRecipeAll.setData(null);
			respRecipeAll.setResult("004");
		}
		}
		return respRecipeAll;
	}
	@Override
	public RespRecipe findSingleRecipe(String rId) {
		Recipe recipe = (Recipe) get(Recipe.class,rId);
		RespRecipe respRecipe = new RespRecipe("001",recipe);
		return respRecipe;
	}

}
