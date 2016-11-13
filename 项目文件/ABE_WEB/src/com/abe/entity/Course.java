package com.abe.entity;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private String CId;
	private String CName;

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String CId) {
		this.CId = CId;
	}

	/** full constructor */
	public Course(String CId, String CName) {
		this.CId = CId;
		this.CName = CName;
	}

	// Property accessors

	public String getCId() {
		return this.CId;
	}

	public void setCId(String CId) {
		this.CId = CId;
	}

	public String getCName() {
		return this.CName;
	}

	public void setCName(String CName) {
		this.CName = CName;
	}

	@Override
	public String toString() {
		return "Course [CId=" + CId + ", CName=" + CName + "]";
	}

}