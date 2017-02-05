package com.abe.entity.other;

import java.io.Serializable;

import com.abe.entity.PersonInform;

public class RespPersonInform implements Serializable {
	private static final long serialVersionUID = 1L;
	private String result;
	private PersonInform data;
	public RespPersonInform() {
	}
	public RespPersonInform(String result, PersonInform data) {
		this.result = result;
		this.data = data;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public PersonInform getData() {
		return data;
	}
	public void setData(PersonInform data) {
		this.data = data;
	}
}
