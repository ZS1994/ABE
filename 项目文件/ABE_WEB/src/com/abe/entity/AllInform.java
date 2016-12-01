package com.abe.entity;

/**
 * AllInform entity. @author MyEclipse Persistence Tools
 */

public class AllInform implements java.io.Serializable {

	// Fields

	private String aiId;
	private String aiTitle;
	private String itId;
	private String aiContent;
	private String aiStatus;
	private String aiTime;
	// -------------------------------
	private InfoTeacher teacher;

	// Constructors
	public InfoTeacher getTeacher() {
		return teacher;
	}

	public void setTeacher(InfoTeacher teacher) {
		this.teacher = teacher;
	}

	/** default constructor */
	public AllInform() {
	}

	/** minimal constructor */
	public AllInform(String aiId) {
		this.aiId = aiId;
	}

	/** full constructor */
	public AllInform(String aiId, String aiTitle, String itId,
			String aiContent, String aiStatus, String aiTime) {
		this.aiId = aiId;
		this.aiTitle = aiTitle;
		this.itId = itId;
		this.aiContent = aiContent;
		this.aiStatus = aiStatus;
		this.aiTime = aiTime;
	}

	// Property accessors

	public String getAiId() {
		return this.aiId;
	}

	public void setAiId(String aiId) {
		this.aiId = aiId;
	}

	public String getAiTitle() {
		return this.aiTitle;
	}

	public void setAiTitle(String aiTitle) {
		this.aiTitle = aiTitle;
	}

	public String getItId() {
		return this.itId;
	}

	public void setItId(String itId) {
		this.itId = itId;
	}

	public String getAiContent() {
		return this.aiContent;
	}

	public void setAiContent(String aiContent) {
		this.aiContent = aiContent;
	}

	public String getAiStatus() {
		return this.aiStatus;
	}

	public void setAiStatus(String aiStatus) {
		this.aiStatus = aiStatus;
	}

	public String getAiTime() {
		return this.aiTime;
	}

	public void setAiTime(String aiTime) {
		this.aiTime = aiTime;
	}

}