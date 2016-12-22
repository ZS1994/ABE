package com.abe.entity.other;

import java.io.Serializable;

import com.abe.entity.Recipe;

public class RespRecipe implements Serializable {
	private static final long serialVersionUID = 1L;
	private String result;
	private Recipe data;
	
	
	public RespRecipe(String result, Recipe data) {
		this.result = result;
		this.data = data;
	}
	public RespRecipe() {
		// TODO Auto-generated constructor stub
	}
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
