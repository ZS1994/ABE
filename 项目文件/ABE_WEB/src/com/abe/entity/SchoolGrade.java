package com.abe.entity;

/**
 * SchoolGrade entity. @author MyEclipse Persistence Tools
 */

public class SchoolGrade implements java.io.Serializable {

	// Fields

	private String sgId;
	private String sgName;
	private String SId;

	private School school;//学校信息
	// Constructors

	/** default constructor */
	public SchoolGrade() {
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	/** minimal constructor */
	public SchoolGrade(String sgId) {
		this.sgId = sgId;
	}

	/** full constructor */
	public SchoolGrade(String sgId, String sgName, String SId) {
		this.sgId = sgId;
		this.sgName = sgName;
		this.SId = SId;
	}

	// Property accessors

	public String getSgId() {
		return this.sgId;
	}

	public void setSgId(String sgId) {
		this.sgId = sgId;
	}

	public String getSgName() {
		return this.sgName;
	}

	public void setSgName(String sgName) {
		this.sgName = sgName;
	}

	public String getSId() {
		return this.SId;
	}

	public void setSId(String SId) {
		this.SId = SId;
	}

}