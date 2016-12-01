package com.abe.entity.app;

import java.io.Serializable;
import java.util.List;

import com.abe.entity.ClassInform;

public class RespClassInformAll implements Serializable {
	private static final long serialVersionUID = 1L;
	private String result;
	private List<ClassInform> data;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<ClassInform> getData() {
		return data;
	}
	public void setData(List<ClassInform> data) {
		this.data = data;
	}
}
