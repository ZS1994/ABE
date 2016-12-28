package com.abe.action;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.abe.entity.Recipe;
import com.abe.entity.other.RespRecipe;
import com.abe.entity.other.RespRecipeAll;
import com.abe.service.iBaseService;
import com.abe.service.iRecipeService;

public class RecipeAction extends BaseAction implements iBaseAction {

	
	private static final long serialVersionUID = 1L;

	private iBaseService ser;
	private iRecipeService recipeSer;
	private Recipe recipe;
	private String hint;//提示信息
	
	private Logger logger=Logger.getLogger(SignAction.class);
/**
 * 创建食谱
 * @author 李钊
 */
	public String creatRecipe() throws IOException {
		logger.debug("-------进入creatRecipe--------");
		String scId=(String) getRequest().getParameter("ScId");
		String rType=(String) getRequest().getParameter("RType");
		String rTime=(String) getRequest().getParameter("RTime");
		String rState=(String) getRequest().getParameter("RState");
		String uId=(String) getRequest().getParameter("UId");
		String rImages=(String) getRequest().getParameter("RImages");
		String rImagesUrl=(String) getRequest().getParameter("RImagesUrl");
		String isIdAll=(String) getRequest().getParameter("IsIdAll");
		RespRecipe respRecipe=recipeSer.creatRecipe
		(scId, rType, rTime, rState, uId, rImages,rImagesUrl,isIdAll);
		sendToApp(respRecipe, ser);
		return null;
	}
	/*
	 * 发布食谱(固定修改状态为已发布)
	 * @param Recipe
	 */
	public String releaseRecipe() throws IOException{
		logger.debug("-------进入releaseRecipe--------");
		String rId=(String) getRequest().getParameter("RId");
		String rCreatTime=(String) getRequest().getParameter("RCreatTime");
		String scId=(String) getRequest().getParameter("ScId");
		String rType=(String) getRequest().getParameter("RType");
		String rTime=(String) getRequest().getParameter("RTime");
		String rState=(String) getRequest().getParameter("RState");
		String uId=(String) getRequest().getParameter("UId");
		String rImages=(String) getRequest().getParameter("RImages");
		String isIdAll=(String) getRequest().getParameter("IsIdAll");
		String rImagesUrl=(String) getRequest().getParameter("RImagesUrl");
		RespRecipe respRecipe=recipeSer.releaseRecipe(rId,scId, rType, rTime, rState, uId, rImages, isIdAll,rCreatTime,rImagesUrl);
		sendToApp(respRecipe, ser);
		return null;
	}
	/*
	 * 查询所有食谱(暂时不使用)
	 */
	public String findAllRecipe() throws IOException{
		logger.debug("-------进入findAllRecipe--------");
		String pageNo = (String) getRequest().getParameter("pageNo");
		String pageSize = (String) getRequest().getParameter("Size");
		RespRecipeAll respRecipe = recipeSer.findPageAllRecipe(pageNo,pageSize);
		sendToApp(respRecipe, ser);
		return null;
	}
	/*
	 * 分页查询当前用户创建的食谱
	 */
	public String findCreaterRecipe() throws IOException{
		logger.debug("-------进入findCreaterRecipe--------");
		String uId = (String) getRequest().getParameter("UId");
		String pageNo = (String) getRequest().getParameter("pageNo");
		String pageSize = (String) getRequest().getParameter("Size");
		RespRecipeAll respRecipe = recipeSer.findPageCreaterRecipe(uId,pageNo,pageSize);
		sendToApp(respRecipe, ser);
		return null;
	}
	/*
	 * 删除食谱
	 * @param rId
	 */
	public String deleteRecipe() throws IOException{
		logger.debug("-------进入deleteRecipe--------");
		String rId=(String) getRequest().getParameter("RId");
		RespRecipe respRecipe =  recipeSer.deleteRecipe(rId);
		sendToApp(respRecipe, ser);
	return null;	
	}
	/*
	 * 修改食谱
	 * @param Recipe
	 */
	public String updateRecipe() throws IOException{
		logger.debug("-------进入upDateRecipe--------");
		String rId=(String) getRequest().getParameter("RId");
		String rCreatTime=(String) getRequest().getParameter("RCreatTime");
		String scId = (String) getRequest().getParameter("ScId");
		String rType = (String) getRequest().getParameter("RType");
		String rTime = (String) getRequest().getParameter("RTime");
		String rState = (String) getRequest().getParameter("RState");
		String uId = (String) getRequest().getParameter("UId");
		String rImages = (String) getRequest().getParameter("RImages");
		String rImagesUrl=(String) getRequest().getParameter("RImagesUrl");
		String isIdAll = (String) getRequest().getParameter("IsIdAll");
		String rStatus = (String) getRequest().getParameter("RStatus");
		RespRecipe respRecipe=recipeSer.updateRecipe(rId,scId, rType, rTime, rState, uId, rImages,rImagesUrl, isIdAll,rStatus,rCreatTime);
		sendToApp(respRecipe, ser);
		return null;
	}
	/*
	 * 查看单条食谱信息
	 * @param RID
	 */
	public String findSingleRecipe() throws IOException{
		logger.debug("-------进入findSingleRecipe--------");
		String rId = (String) getRequest().getParameter("RId");
		RespRecipe respRecipe=recipeSer.findSingleRecipe(rId);
		sendToApp(respRecipe, ser);
		return null;
	}
	
	public iBaseService getSer() {
		return ser;
	}
	
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	
	public iRecipeService getRecipeSer() {
		return recipeSer;
	}
	
	public void setRecipeSer(iRecipeService recipeSer) {
		this.recipeSer = recipeSer;
	}
	
	public Recipe getRecipe() {
		return recipe;
	}
	
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	public String getHint() {
		return hint;
	}
	
	public void setHint(String hint) {
		this.hint = hint;
	}
	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearOptions() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearSpace() {
		// TODO Auto-generated method stub

	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String gotoQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryOfFenYe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

}
