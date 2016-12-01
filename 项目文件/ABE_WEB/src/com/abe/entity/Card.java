package com.abe.entity;

import java.sql.Timestamp;

/**
 * Card entity. @author MyEclipse Persistence Tools
 */

public class Card implements java.io.Serializable {

	// Fields

	private String CId;
	private String CType;
	private String srtId;
	private String itId;
	private Timestamp CCreateTime;
	private String CState;

	// Constructors

	/** default constructor */
	public Card() {
	}

	/** minimal constructor */
	public Card(String CId) {
		this.CId = CId;
	}

	/** full constructor */
	public Card(String CId, String CType, String srtId, String itId,
			Timestamp CCreateTime, String CState) {
		this.CId = CId;
		this.CType = CType;
		this.srtId = srtId;
		this.itId = itId;
		this.CCreateTime = CCreateTime;
		this.CState = CState;
	}

	// Property accessors

	public String getCId() {
		return this.CId;
	}

	public void setCId(String CId) {
		this.CId = CId;
	}

	public String getCType() {
		return this.CType;
	}

	public void setCType(String CType) {
		this.CType = CType;
	}

	public String getSrtId() {
		return this.srtId;
	}

	public void setSrtId(String srtId) {
		this.srtId = srtId;
	}

	public String getItId() {
		return this.itId;
	}

	public void setItId(String itId) {
		this.itId = itId;
	}

	public Timestamp getCCreateTime() {
		return this.CCreateTime;
	}

	public void setCCreateTime(Timestamp CCreateTime) {
		this.CCreateTime = CCreateTime;
	}

	public String getCState() {
		return this.CState;
	}

	public void setCState(String CState) {
		this.CState = CState;
	}

}