package com.abe.entity.app;

/**
 * 返回的错误信息
 * @author it023
 *
 */
public class RespError {
	
	private String errorCode;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public RespError(String errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public RespError() {
		super();
	}
	
}
