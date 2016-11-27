package com.abe.entity;

/**
 * StudentParentRel entity. @author MyEclipse Persistence Tools
 */

public class StudentParentRel implements java.io.Serializable {

	// Fields

	private String spId;
	private String isId;
	private String ipId;
	private String spRelation;

	// Constructors

	/** default constructor */
	public StudentParentRel() {
	}

	/** minimal constructor */
	public StudentParentRel(String spId) {
		this.spId = spId;
	}

	/** full constructor */
	public StudentParentRel(String spId, String isId, String ipId,
			String spRelation) {
		this.spId = spId;
		this.isId = isId;
		this.ipId = ipId;
		this.spRelation = spRelation;
	}

	// Property accessors

	public String getSpId() {
		return this.spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getIsId() {
		return this.isId;
	}

	public void setIsId(String isId) {
		this.isId = isId;
	}

	public String getIpId() {
		return this.ipId;
	}

	public void setIpId(String ipId) {
		this.ipId = ipId;
	}

	public String getSpRelation() {
		return this.spRelation;
	}

	public void setSpRelation(String spRelation) {
		this.spRelation = spRelation;
	}

}