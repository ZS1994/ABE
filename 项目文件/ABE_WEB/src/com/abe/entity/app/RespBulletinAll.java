package com.abe.entity.app;

import java.io.Serializable;
import java.util.List;

import com.abe.entity.AllInform;

public class RespBulletinAll implements Serializable {
	private String result;
	private List<AllInform> data;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<AllInform> getData() {
		return data;
	}
	public void setData(List<AllInform> data) {
		this.data = data;
	}
	
}
