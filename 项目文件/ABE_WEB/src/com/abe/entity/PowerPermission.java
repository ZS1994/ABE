package com.abe.entity;

/**
 * PowerPermission entity. @author MyEclipse Persistence Tools
 */

public class PowerPermission implements java.io.Serializable {

	// Fields

	private Integer PId;
	private String PName;

	// Constructors

	/** default constructor */
	public PowerPermission() {
	}

	/** minimal constructor */
	public PowerPermission(Integer PId) {
		this.PId = PId;
	}

	/** full constructor */
	public PowerPermission(Integer PId, String PName) {
		this.PId = PId;
		this.PName = PName;
	}

	// Property accessors

	public Integer getPId() {
		return this.PId;
	}

	public void setPId(Integer PId) {
		this.PId = PId;
	}

	public String getPName() {
		return this.PName;
	}

	public void setPName(String PName) {
		this.PName = PName;
	}

}