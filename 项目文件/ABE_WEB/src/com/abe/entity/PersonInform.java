package com.abe.entity;

/**
 * PersonInform entity. @author MyEclipse Persistence Tools
 */

public class PersonInform implements java.io.Serializable {

	// Fields

	private String piId;
	private String piTitle;
	private String piContent;
	private String UId;
	private String piStatus;
	private String piTime;
	
	//------------------------
	private Users user;
	// Constructors

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	/** default constructor */
	public PersonInform() {
	}

	/** minimal constructor */
	public PersonInform(String piId) {
		this.piId = piId;
	}

	/** full constructor */
	public PersonInform(String piId, String piTitle, String piContent,
			String UId, String piStatus, String piTime) {
		this.piId = piId;
		this.piTitle = piTitle;
		this.piContent = piContent;
		this.UId = UId;
		this.piStatus = piStatus;
		this.piTime = piTime;
	}

	// Property accessors

	public String getPiId() {
		return this.piId;
	}

	public void setPiId(String piId) {
		this.piId = piId;
	}

	public String getPiTitle() {
		return this.piTitle;
	}

	public void setPiTitle(String piTitle) {
		this.piTitle = piTitle;
	}

	public String getPiContent() {
		return this.piContent;
	}

	public void setPiContent(String piContent) {
		this.piContent = piContent;
	}

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

	public String getPiStatus() {
		return this.piStatus;
	}

	public void setPiStatus(String piStatus) {
		this.piStatus = piStatus;
	}

	public String getPiTime() {
		return this.piTime;
	}

	public void setPiTime(String piTime) {
		this.piTime = piTime;
	}

}