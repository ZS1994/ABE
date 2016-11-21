package com.abe.entity.app;

import java.io.Serializable;
import java.util.List;

import com.abe.entity.News;

public class RespNewsAll implements Serializable {
	private static final long serialVersionUID = 1L;
	private String result;
	private List<News> data;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<News> getData() {
		return data;
	}
	public void setData(List<News> data) {
		this.data = data;
	}
	

}
