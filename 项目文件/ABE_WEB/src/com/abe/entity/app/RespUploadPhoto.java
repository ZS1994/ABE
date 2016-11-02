package com.abe.entity.app;

import com.abe.entity.Users;


public class RespUploadPhoto {
	
	private String result;
	private Users data;
	
	public RespUploadPhoto() {
		super();
	}


	@Override
	public String toString() {
		return "RespUploadPhoto [data=" + data + ", result=" + result + "]";
	}


	public RespUploadPhoto(String result, Users data) {
		super();
		this.result = result;
		this.data = data;
		//去掉不显示的字段
		if (this.data!=null) {
			this.data.setUId(null);
			this.data.setUName(null);
			this.data.setUNote(null);
			this.data.setUNum(null);
			this.data.setUPass(null);
			this.data.setUType(null);
			this.data.setUCreateTime(null);
		}
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public Users getData() {
		return data;
	}


	public void setData(Users data) {
		this.data = data;
	}
	
	
	
}
