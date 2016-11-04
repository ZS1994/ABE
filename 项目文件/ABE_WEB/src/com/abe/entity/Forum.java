package com.abe.entity;

import java.sql.Timestamp;
import java.util.List;


/**
 * Forum entity. @author MyEclipse Persistence Tools
 */

public class Forum implements java.io.Serializable {

	// Fields

	private String FId;
	private String FContent;
	private Integer FLike;
	private Timestamp FCreateTime;
	private String UId;
//--------------------------------
	private Users user;
	private List<ForumComment> comment;
	
	
	// Constructors

	public List<ForumComment> getComment() {
		return comment;
	}

	public void setComment(List<ForumComment> comment) {
		this.comment = comment;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	/** default constructor */
	public Forum() {
	}

	/** minimal constructor */
	public Forum(String FId) {
		this.FId = FId;
	}

	/** full constructor */
	public Forum(String FId, String FContent, Integer FLike,
			Timestamp FCreateTime, String UId) {
		this.FId = FId;
		this.FContent = FContent;
		this.FLike = FLike;
		this.FCreateTime = FCreateTime;
		this.UId = UId;
	}

	// Property accessors

	public String getFId() {
		return this.FId;
	}

	public void setFId(String FId) {
		this.FId = FId;
	}

	public String getFContent() {
		return this.FContent;
	}

	public void setFContent(String FContent) {
		this.FContent = FContent;
	}

	public Integer getFLike() {
		return this.FLike;
	}

	public void setFLike(Integer FLike) {
		this.FLike = FLike;
	}

	public Timestamp getFCreateTime() {
		return this.FCreateTime;
	}

	public void setFCreateTime(Timestamp FCreateTime) {
		this.FCreateTime = FCreateTime;
	}

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

}