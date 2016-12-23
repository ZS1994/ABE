package com.abe.entity.other;

import java.io.Serializable;
import java.util.List;

import com.abe.entity.Return;

public class RespReturnAll implements Serializable {
	private static final long serialVersionUID = 1L;
	private String result;
	private List<Return> data;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<Return> getData() {
		return data;
	}
	public void setData(List<Return> data) {
		this.data = data;
	}
}
