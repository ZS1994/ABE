package com.abe.entity;

import java.sql.Timestamp;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private String UId;
	private String UNum;
	private String UName;
	private String UPass;
	private String UType;
	private Timestamp UCreateTime;
	private String UPhotoPath;
	private String UNote;
	private String trpId;
	private String RId;

	// Constructors
	private PowerRole role;
	private School school;
	
	
	
	/** default constructor */
	public Users() {
	}
	
	
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public PowerRole getRole() {
		return role;
	}
	public void setRole(PowerRole role) {
		this.role = role;
	}


	/** minimal constructor */
	public Users(String UId, String UNum) {
		this.UId = UId;
		this.UNum = UNum;
	}

	/** full constructor */
	public Users(String UId, String UNum, String UName, String UPass,
			String UType, Timestamp UCreateTime, String UPhotoPath,
			String UNote, String trpId, String RId) {
		this.UId = UId;
		this.UNum = UNum;
		this.UName = UName;
		this.UPass = UPass;
		this.UType = UType;
		this.UCreateTime = UCreateTime;
		this.UPhotoPath = UPhotoPath;
		this.UNote = UNote;
		this.trpId = trpId;
		this.RId = RId;
	}

	// Property accessors

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

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

	public String getUPhotoPath() {
		return this.UPhotoPath;
	}

	public void setUPhotoPath(String UPhotoPath) {
		this.UPhotoPath = UPhotoPath;
	}

	public String getUNote() {
		return this.UNote;
	}

	public void setUNote(String UNote) {
		this.UNote = UNote;
	}

	public String getTrpId() {
		return this.trpId;
	}

	public void setTrpId(String trpId) {
		this.trpId = trpId;
	}

	public String getRId() {
		return this.RId;
	}

	public void setRId(String RId) {
		this.RId = RId;
	}

}