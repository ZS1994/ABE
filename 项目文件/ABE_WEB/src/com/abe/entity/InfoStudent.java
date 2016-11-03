package com.abe.entity;

import java.util.Date;

/**
 * InfoStudent entity. @author MyEclipse Persistence Tools
 */

public class InfoStudent implements java.io.Serializable {

	// Fields

	private String isId;
	private String isNum;
	private String isName;
	private String isSex;
	private Date isBirthday;
	private Integer isAge;
	private Integer isLocal;
	private Integer isTeacherChildren;
	private String isSchool;
	private String isGrade;
	private String isClass;
	private Date isIntoYear;
	private String isParentName;
	private String isParentPhone;
	private String isParentRelation;
	private Date isIntoDate;
	private Date isLeaveDate;
	private String isState;
	private String UId;
	private String scId;

	// Constructors

	/** default constructor */
	public InfoStudent() {
	}

	/** minimal constructor */
	public InfoStudent(String isId, String isNum) {
		this.isId = isId;
		this.isNum = isNum;
	}

	/** full constructor */
	public InfoStudent(String isId, String isNum, String isName, String isSex,
			Date isBirthday, Integer isAge, Integer isLocal,
			Integer isTeacherChildren, String isSchool, String isGrade,
			String isClass, Date isIntoYear, String isParentName,
			String isParentPhone, String isParentRelation, Date isIntoDate,
			Date isLeaveDate, String isState, String UId, String scId) {
		this.isId = isId;
		this.isNum = isNum;
		this.isName = isName;
		this.isSex = isSex;
		this.isBirthday = isBirthday;
		this.isAge = isAge;
		this.isLocal = isLocal;
		this.isTeacherChildren = isTeacherChildren;
		this.isSchool = isSchool;
		this.isGrade = isGrade;
		this.isClass = isClass;
		this.isIntoYear = isIntoYear;
		this.isParentName = isParentName;
		this.isParentPhone = isParentPhone;
		this.isParentRelation = isParentRelation;
		this.isIntoDate = isIntoDate;
		this.isLeaveDate = isLeaveDate;
		this.isState = isState;
		this.UId = UId;
		this.scId = scId;
	}

	// Property accessors

	public String getIsId() {
		return this.isId;
	}

	public void setIsId(String isId) {
		this.isId = isId;
	}

	public String getIsNum() {
		return this.isNum;
	}

	public void setIsNum(String isNum) {
		this.isNum = isNum;
	}

	public String getIsName() {
		return this.isName;
	}

	public void setIsName(String isName) {
		this.isName = isName;
	}

	public String getIsSex() {
		return this.isSex;
	}

	public void setIsSex(String isSex) {
		this.isSex = isSex;
	}

	public Date getIsBirthday() {
		return this.isBirthday;
	}

	public void setIsBirthday(Date isBirthday) {
		this.isBirthday = isBirthday;
	}

	public Integer getIsAge() {
		return this.isAge;
	}

	public void setIsAge(Integer isAge) {
		this.isAge = isAge;
	}

	public Integer getIsLocal() {
		return this.isLocal;
	}

	public void setIsLocal(Integer isLocal) {
		this.isLocal = isLocal;
	}

	public Integer getIsTeacherChildren() {
		return this.isTeacherChildren;
	}

	public void setIsTeacherChildren(Integer isTeacherChildren) {
		this.isTeacherChildren = isTeacherChildren;
	}

	public String getIsSchool() {
		return this.isSchool;
	}

	public void setIsSchool(String isSchool) {
		this.isSchool = isSchool;
	}

	public String getIsGrade() {
		return this.isGrade;
	}

	public void setIsGrade(String isGrade) {
		this.isGrade = isGrade;
	}

	public String getIsClass() {
		return this.isClass;
	}

	public void setIsClass(String isClass) {
		this.isClass = isClass;
	}

	public Date getIsIntoYear() {
		return this.isIntoYear;
	}

	public void setIsIntoYear(Date isIntoYear) {
		this.isIntoYear = isIntoYear;
	}

	public String getIsParentName() {
		return this.isParentName;
	}

	public void setIsParentName(String isParentName) {
		this.isParentName = isParentName;
	}

	public String getIsParentPhone() {
		return this.isParentPhone;
	}

	public void setIsParentPhone(String isParentPhone) {
		this.isParentPhone = isParentPhone;
	}

	public String getIsParentRelation() {
		return this.isParentRelation;
	}

	public void setIsParentRelation(String isParentRelation) {
		this.isParentRelation = isParentRelation;
	}

	public Date getIsIntoDate() {
		return this.isIntoDate;
	}

	public void setIsIntoDate(Date isIntoDate) {
		this.isIntoDate = isIntoDate;
	}

	public Date getIsLeaveDate() {
		return this.isLeaveDate;
	}

	public void setIsLeaveDate(Date isLeaveDate) {
		this.isLeaveDate = isLeaveDate;
	}

	public String getIsState() {
		return this.isState;
	}

	public void setIsState(String isState) {
		this.isState = isState;
	}

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

	public String getScId() {
		return this.scId;
	}

	public void setScId(String scId) {
		this.scId = scId;
	}

}