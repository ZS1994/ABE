package com.abe.entity;

/**
 * Vacate entity. @author MyEclipse Persistence Tools
 */

public class Vacate implements java.io.Serializable {

	// Fields

	private String VId;
	private String isId;
	private String UId;
	private String itId;
	private String VContent;
	private String VDate;
	private String VTime;
	private String VResp;
//------------------------------------
	private Users user;
	private InfoTeacher teacher;
	private InfoStudent student;
	// Constructors

	/** default constructor */
	public Vacate() {
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public InfoTeacher getTeacher() {
		return teacher;
	}

	public void setTeacher(InfoTeacher teacher) {
		this.teacher = teacher;
	}

	public InfoStudent getStudent() {
		return student;
	}

	public void setStudent(InfoStudent student) {
		this.student = student;
	}

	/** full constructor */
	public Vacate(String isId, String UId, String itId, String VContent,
			String VDate, String VTime) {
		this.isId = isId;
		this.UId = UId;
		this.itId = itId;
		this.VContent = VContent;
		this.VDate = VDate;
		this.VTime = VTime;
	}

	// Property accessors

	public String getVId() {
		return this.VId;
	}

	public void setVId(String VId) {
		this.VId = VId;
	}

	public String getIsId() {
		return this.isId;
	}

	public void setIsId(String isId) {
		this.isId = isId;
	}

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

	public String getItId() {
		return this.itId;
	}

	public void setItId(String itId) {
		this.itId = itId;
	}

	public String getVContent() {
		return this.VContent;
	}

	public void setVContent(String VContent) {
		this.VContent = VContent;
	}

	public String getVDate() {
		return this.VDate;
	}

	public void setVDate(String VDate) {
		this.VDate = VDate;
	}

	public String getVTime() {
		return this.VTime;
	}

	public void setVTime(String VTime) {
		this.VTime = VTime;
	}

	public String getVResp() {
		return VResp;
	}
	
	public void setVResp(String vResp) {
		VResp = vResp;
	}
}