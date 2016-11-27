package com.abe.entity;

import java.sql.Timestamp;

/**
 * CardLog entity. @author MyEclipse Persistence Tools
 */

public class CardLog implements java.io.Serializable {

	// Fields

	private String clId;
	private String CId;
	private Timestamp clTime;
	private String clState;

	// Constructors

	/** default constructor */
	public CardLog() {
	}

	/** minimal constructor */
	public CardLog(String clId) {
		this.clId = clId;
	}

	/** full constructor */
	public CardLog(String clId, String CId, Timestamp clTime, String clState) {
		this.clId = clId;
		this.CId = CId;
		this.clTime = clTime;
		this.clState = clState;
	}

	// Property accessors

	public String getClId() {
		return this.clId;
	}

	public void setClId(String clId) {
		this.clId = clId;
	}

	public String getCId() {
		return this.CId;
	}

	public void setCId(String CId) {
		this.CId = CId;
	}

	public Timestamp getClTime() {
		return this.clTime;
	}

	public void setClTime(Timestamp clTime) {
		this.clTime = clTime;
	}

	public String getClState() {
		return this.clState;
	}

	public void setClState(String clState) {
		this.clState = clState;
	}

}