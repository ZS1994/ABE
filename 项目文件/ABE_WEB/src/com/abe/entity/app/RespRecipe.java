package com.abe.entity.app;

import com.abe.entity.Recipe;

public class RespRecipe {
	private String result;
	private Recipe data;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Recipe getData() {
		return data;
	}
	public void setData(Recipe data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "SignIn [data=" + data + ", result=" + result + "]";
	}
	
}
