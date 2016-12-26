package com.abe.entity;

import java.sql.Timestamp;

/**
 * PowerRole entity. @author MyEclipse Persistence Tools
 */

public class PowerRole implements java.io.Serializable {

	// Fields

	private String RId;
	private String RName;
	private String RDesc;
	private String RParentIds;
	private Timestamp RCreateTime;

	// Constructors

	/** default constructor */
	public PowerRole() {
	}

	/** minimal constructor */
	public PowerRole(String RId) {
		this.RId = RId;
	}

	/** full constructor */
	public PowerRole(String RId, String RName, String RDesc, String RParentIds,
			Timestamp RCreateTime) {
		this.RId = RId;
		this.RName = RName;
		this.RDesc = RDesc;
		this.RParentIds = RParentIds;
		this.RCreateTime = RCreateTime;
	}

	// Property accessors

	public String getRId() {
		return this.RId;
	}

	public void setRId(String RId) {
		this.RId = RId;
	}

	public String getRName() {
		return this.RName;
	}

	public void setRName(String RName) {
		this.RName = RName;
	}

	public String getRDesc() {
		return this.RDesc;
	}

	public void setRDesc(String RDesc) {
		this.RDesc = RDesc;
	}

	public String getRParentIds() {
		return this.RParentIds;
	}

	public void setRParentIds(String RParentIds) {
		this.RParentIds = RParentIds;
	}

	public Timestamp getRCreateTime() {
		return this.RCreateTime;
	}

	public void setRCreateTime(Timestamp RCreateTime) {
		this.RCreateTime = RCreateTime;
	}

}