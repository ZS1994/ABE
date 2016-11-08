package com.abe.action;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.abe.entity.Recipe;
import com.abe.service.iBaseService;
import com.abe.service.iRecipeService;

public class RecipeAction extends BaseAction implements iBaseAction {

	
	private static final long serialVersionUID = 1L;

	private iBaseService ser;
	private iRecipeService recipeSer;
	private Recipe recipe;
	private String hint;//提示信息
	
	private Logger logger=Logger.getLogger(SignAction.class);
	
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
	/*
	 * 发布食谱
	 * 
	 */
	public String releaseRecipe() throws IOException{
		
		return null;
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
