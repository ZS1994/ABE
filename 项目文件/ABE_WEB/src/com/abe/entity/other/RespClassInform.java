package com.abe.entity.other;

import java.io.Serializable;

import com.abe.entity.ClassInform;

public class RespClassInform implements Serializable {
	private static final long serialVersionUID = 1L;
	private String result;
	private ClassInform data;
	public RespClassInform() {
	}
	public RespClassInform(String result, ClassInform data) {
		this.result = result;
		this.data = data;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public ClassInform getData() {
		return data;
	}
	public void setData(ClassInform data) {
		this.data = data;
	}
}
