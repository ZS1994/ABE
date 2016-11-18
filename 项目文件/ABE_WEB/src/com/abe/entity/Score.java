package com.abe.entity;

import java.sql.Timestamp;

/**
 * Score entity. @author MyEclipse Persistence Tools
 */

public class Score implements java.io.Serializable {

	// Fields

	private String SId;
	private Integer SScore;
	private String CId;
	private String isId;
	private Timestamp SCreateTime;

	// Constructors

	/** default constructor */
	public Score() {
	}

	/** minimal constructor */
	public Score(String SId) {
		this.SId = SId;
	}

	/** full constructor */
	public Score(String SId, Integer SScore, String CId, String isId,
			Timestamp SCreateTime) {
		this.SId = SId;
		this.SScore = SScore;
		this.CId = CId;
		this.isId = isId;
		this.SCreateTime = SCreateTime;
	}

	// Property accessors

	public String getSId() {
		return this.SId;
	}

	public void setSId(String SId) {
		this.SId = SId;
	}

	public Integer getSScore() {
		return this.SScore;
	}

	public void setSScore(Integer SScore) {
		this.SScore = SScore;
	}

	public String getCId() {
		return this.CId;
	}

	public void setCId(String CId) {
		this.CId = CId;
	}

	public String getIsId() {
		return this.isId;
	}

	public void setIsId(String isId) {
		this.isId = isId;
	}

	public Timestamp getSCreateTime() {
		return this.SCreateTime;
	}

	public void setSCreateTime(Timestamp SCreateTime) {
		this.SCreateTime = SCreateTime;
	}

}