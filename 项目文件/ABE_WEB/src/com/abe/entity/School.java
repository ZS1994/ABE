package com.abe.entity;

import java.util.List;

/**
 * School entity. @author MyEclipse Persistence Tools
 */

public class School implements java.io.Serializable {

	// Fields

	private String SId;
	private String SName;
	private String SAddress;
	private String paId;

	private PlaceArea placeArea;
	private List<SchoolGrade> grade; //保存班级信息
	// Constructors

	
	/** default constructor */
	public School() {
	}

	public PlaceArea getPlaceArea() {
		return placeArea;
	}

	public void setPlaceArea(PlaceArea placeArea) {
		this.placeArea = placeArea;
	}

	/** minimal constructor */
	public School(String SId) {
		this.SId = SId;
	}

	/** full constructor */
	public School(String SId, String SName, String SAddress, String paId) {
		this.SId = SId;
		this.SName = SName;
		this.SAddress = SAddress;
		this.paId = paId;
	}

	// Property accessors

	public String getSId() {
		return this.SId;
	}

	public void setSId(String SId) {
		this.SId = SId;
	}

	public String getSName() {
		return this.SName;
	}

	public void setSName(String SName) {
		this.SName = SName;
	}

	public String getSAddress() {
		return this.SAddress;
	}

	public void setSAddress(String SAddress) {
		this.SAddress = SAddress;
	}

	public String getPaId() {
		return this.paId;
	}

	public void setPaId(String paId) {
		this.paId = paId;	}

	public List<SchoolGrade> getGrade() {
		return grade;
	}

	public void setGrade(List<SchoolGrade> grade) {
		this.grade = grade;
	}
	 
	
}