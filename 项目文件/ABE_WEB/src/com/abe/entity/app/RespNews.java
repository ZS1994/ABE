package com.abe.entity.app;

import java.io.Serializable;

import com.abe.entity.News;

public class RespNews implements Serializable {
	private static final long serialVersionUID = 1L;
	private String result;
	private News data;
	
	public RespNews() {
	}
	public RespNews(String result, News data) {
		this.result = result;
		this.data = data;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public News getData() {
		return data;
	}
	public void setData(News data) {
		this.data = data;
	}
	
}
