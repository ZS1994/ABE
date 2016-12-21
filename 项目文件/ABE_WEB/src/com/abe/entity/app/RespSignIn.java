package com.abe.entity.app;

import com.abe.entity.Users;

public class RespSignIn {
	
	private String result;
	private Users data;
	
	
	public RespSignIn() {
	}
	
	public RespSignIn(String result, Users data) {
		super();
		this.result = result;
		this.data = data;
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




	@Override
	public String toString() {
		return "SignIn [data=" + data + ", result=" + result + "]";
	}
	
	
}
