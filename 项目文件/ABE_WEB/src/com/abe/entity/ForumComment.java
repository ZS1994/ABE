package com.abe.entity;

import java.sql.Timestamp;

/**
 * ForumComment entity. @author MyEclipse Persistence Tools
 */

public class ForumComment implements java.io.Serializable {

	// Fields

	private String fcId;
	private String fcContent;
	private Timestamp fcCreateTime;
	private String UId;
	private String FId;
//------------------
	private Users user;
	
	// Constructors

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	/** default constructor */
	public ForumComment() {
	}

	/** minimal constructor */
	public ForumComment(String fcId) {
		this.fcId = fcId;
	}

	/** full constructor */
	public ForumComment(String fcId, String fcContent, Timestamp fcCreateTime,
			String UId, String FId) {
		this.fcId = fcId;
		this.fcContent = fcContent;
		this.fcCreateTime = fcCreateTime;
		this.UId = UId;
		this.FId = FId;
	}

	// Property accessors

	public String getFcId() {
		return this.fcId;
	}

	public void setFcId(String fcId) {
		this.fcId = fcId;
	}

	public String getFcContent() {
		return this.fcContent;
	}

	public void setFcContent(String fcContent) {
		this.fcContent = fcContent;
	}

	public Timestamp getFcCreateTime() {
		return this.fcCreateTime;
	}

	public void setFcCreateTime(Timestamp fcCreateTime) {
		this.fcCreateTime = fcCreateTime;
	}

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

	public String getFId() {
		return this.FId;
	}

	public void setFId(String FId) {
		this.FId = FId;
	}

}