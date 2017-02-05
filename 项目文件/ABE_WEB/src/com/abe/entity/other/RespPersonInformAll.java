package com.abe.entity.other;

import java.io.Serializable;
import java.util.List;

import com.abe.entity.PersonInform;

public class RespPersonInformAll implements Serializable {
	private static final long serialVersionUID = 1L;
	private String result;
	private List<PersonInform> data;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<PersonInform> getData() {
		return data;
	}
	public void setData(List<PersonInform> data) {
		this.data = data;
	}
}
