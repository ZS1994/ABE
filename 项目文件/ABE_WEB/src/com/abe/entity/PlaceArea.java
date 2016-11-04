package com.abe.entity;

/**
 * PlaceArea entity. @author MyEclipse Persistence Tools
 */

public class PlaceArea implements java.io.Serializable {

	// Fields

	private String paId;
	private String paName;
	private String pcId;

	// Constructors

	/** default constructor */
	public PlaceArea() {
	}

	/** minimal constructor */
	public PlaceArea(String paId) {
		this.paId = paId;
	}

	/** full constructor */
	public PlaceArea(String paId, String paName, String pcId) {
		this.paId = paId;
		this.paName = paName;
		this.pcId = pcId;
	}

	// Property accessors

	public String getPaId() {
		return this.paId;
	}

	public void setPaId(String paId) {
		this.paId = paId;
	}

	public String getPaName() {
		return this.paName;
	}

	public void setPaName(String paName) {
		this.paName = paName;
	}

	public String getPcId() {
		return this.pcId;
	}

	public void setPcId(String pcId) {
		this.pcId = pcId;
	}

}