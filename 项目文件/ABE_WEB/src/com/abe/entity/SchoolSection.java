package com.abe.entity;

/**
 * SchoolSection entity. @author MyEclipse Persistence Tools
 */

public class SchoolSection implements java.io.Serializable {

	// Fields

	private String ssId;
	private String ssName;
	private String SId;
	private String ssIdLast;

	// Constructors

	/** default constructor */
	public SchoolSection() {
	}

	/** minimal constructor */
	public SchoolSection(String ssId) {
		this.ssId = ssId;
	}

	/** full constructor */
	public SchoolSection(String ssId, String ssName, String SId, String ssIdLast) {
		this.ssId = ssId;
		this.ssName = ssName;
		this.SId = SId;
		this.ssIdLast = ssIdLast;
	}

	// Property accessors

	public String getSsId() {
		return this.ssId;
	}

	public void setSsId(String ssId) {
		this.ssId = ssId;
	}

	public String getSsName() {
		return this.ssName;
	}

	public void setSsName(String ssName) {
		this.ssName = ssName;
	}

	public String getSId() {
		return this.SId;
	}

	public void setSId(String SId) {
		this.SId = SId;
	}

	public String getSsIdLast() {
		return this.ssIdLast;
	}

	public void setSsIdLast(String ssIdLast) {
		this.ssIdLast = ssIdLast;
	}

}