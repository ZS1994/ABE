package com.abe.entity;

import java.sql.Timestamp;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private String UNum;
	private String UName;
	private String UPass;
	private String UType;
	private Timestamp UCreateTime;
	private String UNote;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String UNum) {
		this.UNum = UNum;
	}

	/** full constructor */
	public Users(String UNum, String UName, String UPass, String UType,
			Timestamp UCreateTime, String UNote) {
		this.UNum = UNum;
		this.UName = UName;
		this.UPass = UPass;
		this.UType = UType;
		this.UCreateTime = UCreateTime;
		this.UNote = UNote;
	}

	// Property accessors

	public String getUNum() {
		return this.UNum;
	}

	public void setUNum(String UNum) {
		this.UNum = UNum;
	}

	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	public String getUPass() {
		return this.UPass;
	}

	public void setUPass(String UPass) {
		this.UPass = UPass;
	}

	public String getUType() {
		return this.UType;
	}

	public void setUType(String UType) {
		this.UType = UType;
	}

	public Timestamp getUCreateTime() {
		return this.UCreateTime;
	}

	public void setUCreateTime(Timestamp UCreateTime) {
		this.UCreateTime = UCreateTime;
	}

	public String getUNote() {
		return this.UNote;
	}

	public void setUNote(String UNote) {
		this.UNote = UNote;
	}

}