package com.abe.entity.other;

import java.io.Serializable;
import java.util.List;

import com.abe.entity.Vacate;

public class RespVacateAll implements Serializable{
	private static final long serialVersionUID = 1L;
	private String result;
	private List<Vacate> data;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<Vacate> getData() {
		return data;
	}
	public void setData(List<Vacate> data) {
		this.data = data;
	}
	
}
