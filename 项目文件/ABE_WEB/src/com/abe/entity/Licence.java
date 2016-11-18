package com.abe.entity;

import java.sql.Timestamp;

/**
 * Licence entity. @author MyEclipse Persistence Tools
 */

public class Licence implements java.io.Serializable {

	// Fields

	private String UId;
	private String LLicence;
	private String LIp;
	private Timestamp LDateStart;
	private Timestamp LDateEnd;

	// Constructors

	/** default constructor */
	public Licence() {
	}

	/** minimal constructor */
	public Licence(String UId) {
		this.UId = UId;
	}

	/** full constructor */
	public Licence(String UId, String LLicence, String LIp,
			Timestamp LDateStart, Timestamp LDateEnd) {
		this.UId = UId;
		this.LLicence = LLicence;
		this.LIp = LIp;
		this.LDateStart = LDateStart;
		this.LDateEnd = LDateEnd;
	}

	// Property accessors

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

	public String getLLicence() {
		return this.LLicence;
	}

	public void setLLicence(String LLicence) {
		this.LLicence = LLicence;
	}

	public String getLIp() {
		return this.LIp;
	}

	public void setLIp(String LIp) {
		this.LIp = LIp;
	}

	public Timestamp getLDateStart() {
		return this.LDateStart;
	}

	public void setLDateStart(Timestamp LDateStart) {
		this.LDateStart = LDateStart;
	}

	public Timestamp getLDateEnd() {
		return this.LDateEnd;
	}

	public void setLDateEnd(Timestamp LDateEnd) {
		this.LDateEnd = LDateEnd;
	}

}