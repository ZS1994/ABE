package com.abe.entity.app;


public class RespSignUp {
	
	private String result;
	private String UPhotoPath;
	
	public RespSignUp() {
		super();
	}
	public RespSignUp(String result, String uPhotoPath) {
		super();
		this.result = result;
		UPhotoPath = uPhotoPath;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getUPhotoPath() {
		return UPhotoPath;
	}
	public void setUPhotoPath(String uPhotoPath) {
		UPhotoPath = uPhotoPath;
	}
	
	
	
	
}
