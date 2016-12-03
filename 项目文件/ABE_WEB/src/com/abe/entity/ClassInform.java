package com.abe.entity;

/**
 * ClassInform entity. @author MyEclipse Persistence Tools
 */

public class ClassInform implements java.io.Serializable {

	// Fields

	private String ciId;
	private String ciTitle;
	private String itId;
	private String ciContent;
	private String scId;
	private String ciStatus;
	private String ciTime;

	//----------------
	private InfoTeacher teacher;
	private SchoolClass classs;
	// Constructors
	
	public InfoTeacher getTeacher() {
		return teacher;
	}

	public void setTeacher(InfoTeacher teacher) {
		this.teacher = teacher;
	}

	public SchoolClass getClasss() {
		return classs;
	}

	public void setClasss(SchoolClass classs) {
		this.classs = classs;
	}

	/** default constructor */
	public ClassInform() {
	}

	/** minimal constructor */
	public ClassInform(String ciId) {
		this.ciId = ciId;
	}

	/** full constructor */
	public ClassInform(String ciId, String ciTitle, String itId,
			String ciContent, String scId, String ciStatus, String ciTime) {
		this.ciId = ciId;
		this.ciTitle = ciTitle;
		this.itId = itId;
		this.ciContent = ciContent;
		this.scId = scId;
		this.ciStatus = ciStatus;
		this.ciTime = ciTime;
	}

	// Property accessors

	public String getCiId() {
		return this.ciId;
	}

	public void setCiId(String ciId) {
		this.ciId = ciId;
	}

	public String getCiTitle() {
		return this.ciTitle;
	}

	public void setCiTitle(String ciTitle) {
		this.ciTitle = ciTitle;
	}

	public String getItId() {
		return this.itId;
	}

	public void setItId(String itId) {
		this.itId = itId;
	}

	public String getCiContent() {
		return this.ciContent;
	}

	public void setCiContent(String ciContent) {
		this.ciContent = ciContent;
	}

	public String getScId() {
		return this.scId;
	}

	public void setScId(String scId) {
		this.scId = scId;
	}

	public String getCiStatus() {
		return this.ciStatus;
	}

	public void setCiStatus(String ciStatus) {
		this.ciStatus = ciStatus;
	}

	public String getCiTime() {
		return this.ciTime;
	}

	public void setCiTime(String ciTime) {
		this.ciTime = ciTime;
	}

}