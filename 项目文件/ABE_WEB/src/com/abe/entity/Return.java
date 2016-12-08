package com.abe.entity;

/**
 * Return entity. @author MyEclipse Persistence Tools
 */

public class Return implements java.io.Serializable {

	// Fields

	private String RId;
	private String RContent;
	private String RTime;
	private String RStatus;
	private String UId;
//-----------------------------
	private Users user;
	// Constructors

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	/** default constructor */
	public Return() {
	}

	/** minimal constructor */
	public Return(String RId) {
		this.RId = RId;
	}

	/** full constructor */
	public Return(String RId, String RContent, String RTime, String RStatus,
			String UId) {
		this.RId = RId;
		this.RContent = RContent;
		this.RTime = RTime;
		this.RStatus = RStatus;
		this.UId = UId;
	}

	// Property accessors

	public String getRId() {
		return this.RId;
	}

	public void setRId(String RId) {
		this.RId = RId;
	}

	public String getRContent() {
		return this.RContent;
	}

	public void setRContent(String RContent) {
		this.RContent = RContent;
	}

	public String getRTime() {
		return this.RTime;
	}

	public void setRTime(String RTime) {
		this.RTime = RTime;
	}

	public String getRStatus() {
		return this.RStatus;
	}

	public void setRStatus(String RStatus) {
		this.RStatus = RStatus;
	}

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

}