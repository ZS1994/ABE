package com.abe.entity.other;

import java.io.Serializable;

import com.abe.entity.AllInform;

public class RespBulletin implements Serializable {
	private static final long serialVersionUID = 1L;
	private String result;
	private AllInform data;
	
	public RespBulletin() {
	}
	public RespBulletin(String result, AllInform data) {
		this.result = result;
		this.data = data;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public AllInform getData() {
		return data;
	}
	public void setData(AllInform data) {
		this.data = data;
	}
	
}
