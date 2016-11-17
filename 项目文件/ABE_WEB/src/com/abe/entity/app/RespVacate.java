package com.abe.entity.app;

import java.io.Serializable;

import com.abe.entity.Vacate;

public class RespVacate implements Serializable {
	private static final long serialVersionUID = 1L;
	private String result;
	private Vacate data;
	
	public RespVacate(String result, Vacate data) {
		this.result = result;
		this.data = data;
	}
	
	public RespVacate() {
		super();
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Vacate getData() {
		return data;
	}
	public void setData(Vacate data) {
		this.data = data;
	}
	
}
