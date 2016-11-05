package com.abe.entity;

/**
 * PlaceCity entity. @author MyEclipse Persistence Tools
 */

public class PlaceCity implements java.io.Serializable {

	// Fields

	private String pcId;
	private String pcName;
	private String ppId;

	// Constructors

	/** default constructor */
	public PlaceCity() {
	}

	/** minimal constructor */
	public PlaceCity(String pcId) {
		this.pcId = pcId;
	}

	/** full constructor */
	public PlaceCity(String pcId, String pcName, String ppId) {
		this.pcId = pcId;
		this.pcName = pcName;
		this.ppId = ppId;
	}

	// Property accessors

	public String getPcId() {
		return this.pcId;
	}

	public void setPcId(String pcId) {
		this.pcId = pcId;
	}

	public String getPcName() {
		return this.pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public String getPpId() {
		return this.ppId;
	}

	public void setPpId(String ppId) {
		this.ppId = ppId;
	}

}