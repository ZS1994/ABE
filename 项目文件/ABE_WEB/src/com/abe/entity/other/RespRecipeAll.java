package com.abe.entity.other;

import java.io.Serializable;
import java.util.List;

import com.abe.entity.Recipe;

public class RespRecipeAll implements Serializable {
	private static final long serialVersionUID = 1L;
	private String result;
	private List<Recipe> data;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<Recipe> getData() {
		return data;
	}
	public void setData(List<Recipe> data) {
		this.data = data;
	}
}
