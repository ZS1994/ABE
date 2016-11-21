package com.abe.entity;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private String NId;
	private String NTitle;
	private String NContent;
	private String NImgs;
	private String NUrl;
	private String NOrigin;
	private String NType;
	private String NCreatTime;
	private String NFinalTime;
	private String NIstop;
	private String UId;
	private String NStatus;
	//--------------------------------
	private Users user;
	// Constructors

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(String NId, String NTitle) {
		this.NId = NId;
		this.NTitle = NTitle;
	}

	/** full constructor */
	public News(String NId, String NTitle, String NContent, String NImgs,
			String NUrl, String NOrigin, String NType, String NCreatTime,
			String NFinalTime, String NIstop, String UId, String NStatus) {
		this.NId = NId;
		this.NTitle = NTitle;
		this.NContent = NContent;
		this.NImgs = NImgs;
		this.NUrl = NUrl;
		this.NOrigin = NOrigin;
		this.NType = NType;
		this.NCreatTime = NCreatTime;
		this.NFinalTime = NFinalTime;
		this.NIstop = NIstop;
		this.UId = UId;
		this.NStatus = NStatus;
	}

	// Property accessors

	public String getNId() {
		return this.NId;
	}

	public void setNId(String NId) {
		this.NId = NId;
	}

	public String getNTitle() {
		return this.NTitle;
	}

	public void setNTitle(String NTitle) {
		this.NTitle = NTitle;
	}

	public String getNContent() {
		return this.NContent;
	}

	public void setNContent(String NContent) {
		this.NContent = NContent;
	}

	public String getNImgs() {
		return this.NImgs;
	}

	public void setNImgs(String NImgs) {
		this.NImgs = NImgs;
	}

	public String getNUrl() {
		return this.NUrl;
	}

	public void setNUrl(String NUrl) {
		this.NUrl = NUrl;
	}

	public String getNOrigin() {
		return this.NOrigin;
	}

	public void setNOrigin(String NOrigin) {
		this.NOrigin = NOrigin;
	}

	public String getNType() {
		return this.NType;
	}

	public void setNType(String NType) {
		this.NType = NType;
	}

	public String getNCreatTime() {
		return this.NCreatTime;
	}

	public void setNCreatTime(String NCreatTime) {
		this.NCreatTime = NCreatTime;
	}

	public String getNFinalTime() {
		return this.NFinalTime;
	}

	public void setNFinalTime(String NFinalTime) {
		this.NFinalTime = NFinalTime;
	}

	public String getNIstop() {
		return this.NIstop;
	}

	public void setNIstop(String NIstop) {
		this.NIstop = NIstop;
	}

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

	public String getNStatus() {
		return this.NStatus;
	}

	public void setNStatus(String NStatus) {
		this.NStatus = NStatus;
	}

}