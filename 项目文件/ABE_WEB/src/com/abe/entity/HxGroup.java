package com.abe.entity;

import java.sql.Timestamp;

/**
 * HxGroup entity. @author MyEclipse Persistence Tools
 */

public class HxGroup implements java.io.Serializable {

	// Fields

	private String GId;
	private String GName;
	private String UId;
	private String GDesc;
	private Timestamp GCreateTime;

	// Constructors

	/** default constructor */
	public HxGroup() {
	}

	/** minimal constructor */
	public HxGroup(String GId) {
		this.GId = GId;
	}

	/** full constructor */
	public HxGroup(String GId, String GName, String UId, String GDesc,
			Timestamp GCreateTime) {
		this.GId = GId;
		this.GName = GName;
		this.UId = UId;
		this.GDesc = GDesc;
		this.GCreateTime = GCreateTime;
	}

	// Property accessors

	public String getGId() {
		return this.GId;
	}

	public void setGId(String GId) {
		this.GId = GId;
	}

	public String getGName() {
		return this.GName;
	}

	public void setGName(String GName) {
		this.GName = GName;
	}

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

	public String getGDesc() {
		return this.GDesc;
	}

	public void setGDesc(String GDesc) {
		this.GDesc = GDesc;
	}

	public Timestamp getGCreateTime() {
		return this.GCreateTime;
	}

	public void setGCreateTime(Timestamp GCreateTime) {
		this.GCreateTime = GCreateTime;
	}

	@Override
	public String toString() {
		return "HxGroup [GCreateTime=" + GCreateTime + ", GDesc=" + GDesc
				+ ", GId=" + GId + ", GName=" + GName + ", UId=" + UId + "]";
	}

}