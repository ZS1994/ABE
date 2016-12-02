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
	private String GNote;

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
			Timestamp GCreateTime, String GNote) {
		this.GId = GId;
		this.GName = GName;
		this.UId = UId;
		this.GDesc = GDesc;
		this.GCreateTime = GCreateTime;
		this.GNote = GNote;
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

	public String getGNote() {
		return this.GNote;
	}

	public void setGNote(String GNote) {
		this.GNote = GNote;
	}

}