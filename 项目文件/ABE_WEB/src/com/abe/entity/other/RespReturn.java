package com.abe.entity.other;

import java.io.Serializable;

import com.abe.entity.Return;

public class RespReturn implements Serializable {
	private static final long serialVersionUID = 1L;
	private String result;
	private Return data;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Return getData() {
		return data;
	}
	public void setData(Return data) {
		this.data = data;
	}
	
}
