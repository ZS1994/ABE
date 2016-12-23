package com.abe.entity.other;

import java.util.List;

import com.abe.entity.Forum;

public class RespForumAll {
	private String result;
	private List<Forum> data;
	
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<Forum> getData() {
		return data;
	}
	public void setData(List<Forum> data) {
		this.data = data;
	}
	
}
