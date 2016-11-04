package com.abe.entity;

/**
 * SchoolClass entity. @author MyEclipse Persistence Tools
 */

public class SchoolClass implements java.io.Serializable {

	// Fields

	private String scId;
	private String scNaem;
	private String sgId;
	private String itId;

	// Constructors

	/** default constructor */
	public SchoolClass() {
	}

	/** minimal constructor */
	public SchoolClass(String scId) {
		this.scId = scId;
	}

	/** full constructor */
	public SchoolClass(String scId, String scNaem, String sgId, String itId) {
		this.scId = scId;
		this.scNaem = scNaem;
		this.sgId = sgId;
		this.itId = itId;
	}

	// Property accessors

	public String getScId() {
		return this.scId;
	}

	public void setScId(String scId) {
		this.scId = scId;
	}

	public String getScNaem() {
		return this.scNaem;
	}

	public void setScNaem(String scNaem) {
		this.scNaem = scNaem;
	}

	public String getSgId() {
		return this.sgId;
	}

	public void setSgId(String sgId) {
		this.sgId = sgId;
	}

	public String getItId() {
		return this.itId;
	}

	public void setItId(String itId) {
		this.itId = itId;
	}

}