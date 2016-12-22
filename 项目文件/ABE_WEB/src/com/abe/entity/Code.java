package com.abe.entity;

import java.sql.Timestamp;

/**
 * Code entity. @author MyEclipse Persistence Tools
 */

public class Code implements java.io.Serializable {

	// Fields

	private String UId;
	private String CPhone;
	private String CCode;
	private Timestamp CTime;
	private Timestamp CNoTime;

	// Constructors

	/** default constructor */
	public Code() {
	}

	/** minimal constructor */
	public Code(String UId) {
		this.UId = UId;
	}

	/** full constructor */
	public Code(String UId, String CPhone, String CCode, Timestamp CTime,
			Timestamp CNoTime) {
		this.UId = UId;
		this.CPhone = CPhone;
		this.CCode = CCode;
		this.CTime = CTime;
		this.CNoTime = CNoTime;
	}

	// Property accessors

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

	public String getCPhone() {
		return this.CPhone;
	}

	public void setCPhone(String CPhone) {
		this.CPhone = CPhone;
	}

	public String getCCode() {
		return this.CCode;
	}

	public void setCCode(String CCode) {
		this.CCode = CCode;
	}

	public Timestamp getCTime() {
		return this.CTime;
	}

	public void setCTime(Timestamp CTime) {
		this.CTime = CTime;
	}

	public Timestamp getCNoTime() {
		return this.CNoTime;
	}

	public void setCNoTime(Timestamp CNoTime) {
		this.CNoTime = CNoTime;
	}

}