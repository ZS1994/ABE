package com.abe.action;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.abe.entity.Recipe;
import com.abe.entity.app.RespRecipe;
import com.abe.entity.app.RespRecipeAll;
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
		String isIdAll=(String) getRequest().getParameter("IsIdAll");
		RespRecipe respRecipe=recipeSer.creatRecipe
		(scId, rType, rTime, rState, uId, rImages,isIdAll);
		JSONObject jsonObject=ser.objToJson(respRecipe, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}
	/*
	 * 发布食谱(固定修改状态为已发布)
	 * 
	 */
	public String releaseRecipe() throws IOException{
		logger.debug("-------进入releaseRecipe--------");
		String scId=(String) getRequest().getParameter("ScId");
		String rType=(String) getRequest().getParameter("RType");
		String rTime=(String) getRequest().getParameter("RTime");
		String rState=(String) getRequest().getParameter("RState");
		String uId=(String) getRequest().getParameter("UId");
		String rImages=(String) getRequest().getParameter("RImages");
		String isIdAll=(String) getRequest().getParameter("IsIdAll");
		RespRecipe respRecipe=recipeSer.releaseRecipe(scId, rType, rTime, rState, uId, rImages, isIdAll);
		JSONObject jsonObject=ser.objToJson(respRecipe, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}
	/*
	 * 分页查询所有食谱
	 */
	public String findAllRecipe() throws IOException{
		logger.debug("-------进入findRecipe--------");
		RespRecipeAll respRecipe=recipeSer.findPageAllRecipe();
		JSONObject jsonObject=ser.objToJson(respRecipe, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
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
