package com.abe.entity;

/**
 * ForumLike entity. @author MyEclipse Persistence Tools
 */

public class ForumLike implements java.io.Serializable {

	// Fields

	private String flId;
	private String FId;
	private String UId;

	// Constructors

	/** default constructor */
	public ForumLike() {
	}

	/** minimal constructor */
	public ForumLike(String flId) {
		this.flId = flId;
	}

	/** full constructor */
	public ForumLike(String flId, String FId, String UId) {
		this.flId = flId;
		this.FId = FId;
		this.UId = UId;
	}

	// Property accessors

	public String getFlId() {
		return this.flId;
	}

	public void setFlId(String flId) {
		this.flId = flId;
	}

	public String getFId() {
		return this.FId;
	}

	public void setFId(String FId) {
		this.FId = FId;
	}

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

}