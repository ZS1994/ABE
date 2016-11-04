package com.abe.entity;

/**
 * PlaceProvince entity. @author MyEclipse Persistence Tools
 */

public class PlaceProvince implements java.io.Serializable {

	// Fields

	private String ppId;
	private String ppName;

	// Constructors

	/** default constructor */
	public PlaceProvince() {
	}

	/** minimal constructor */
	public PlaceProvince(String ppId) {
		this.ppId = ppId;
	}

	/** full constructor */
	public PlaceProvince(String ppId, String ppName) {
		this.ppId = ppId;
		this.ppName = ppName;
	}

	// Property accessors

	public String getPpId() {
		return this.ppId;
	}

	public void setPpId(String ppId) {
		this.ppId = ppId;
	}

	public String getPpName() {
		return this.ppName;
	}

	public void setPpName(String ppName) {
		this.ppName = ppName;
	}

}