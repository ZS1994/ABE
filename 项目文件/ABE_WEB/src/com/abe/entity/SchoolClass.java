package com.abe.entity;

/**
 * SchoolClass entity. @author MyEclipse Persistence Tools
 */

public class SchoolClass implements java.io.Serializable {

	// Fields

	private String scId;
	private String scName;
	private String sgId;
	private String itId;

	
	private SchoolGrade schoolGrade;//年级信息
	
	// Constructors

	public SchoolGrade getSchoolGrade() {
		return schoolGrade;
	}

	public void setSchoolGrade(SchoolGrade schoolGrade) {
		this.schoolGrade = schoolGrade;
	}

	/** default constructor */
	public SchoolClass() {
	}

	/** minimal constructor */
	public SchoolClass(String scId) {
		this.scId = scId;
	}

	/** full constructor */
	public SchoolClass(String scId, String scName, String sgId, String itId) {
		this.scId = scId;
		this.scName = scName;
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

	public String getScName() {
		return this.scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
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

	@Override
	public String toString() {
		return "SchoolClass [itId=" + itId + ", scId=" + scId + ", scName="
				+ scName + ", sgId=" + sgId + "]";
	}

}