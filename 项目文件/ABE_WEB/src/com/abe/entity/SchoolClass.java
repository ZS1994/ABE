package com.abe.entity;

import java.sql.Timestamp;
import java.util.List;

/**
 * SchoolClass entity. @author MyEclipse Persistence Tools
 */

public class SchoolClass implements java.io.Serializable {

	// Fields

	private String scId;
	private String scName;
	private String sgId;
	private String itId;
	private Timestamp scCreateTime;
	private String scState;

	// Constructors
	private List<InfoStudent> student;//保存学生信息
	private SchoolGrade schoolGrade;//年级信息
	private InfoTeacher infoTeacher;//教师信息
	
	/** default constructor */
	public SchoolClass() {
	}

	/** minimal constructor */
	public SchoolClass(String scId) {
		this.scId = scId;
	}

	/** full constructor */
	public SchoolClass(String scId, String scName, String sgId, String itId,
			Timestamp scCreateTime, String scState) {
		this.scId = scId;
		this.scName = scName;
		this.sgId = sgId;
		this.itId = itId;
		this.scCreateTime = scCreateTime;
		this.scState = scState;
	}

	// Property accessors

	public String getScId() {
		return this.scId;
	}

	public void setScId(String scId) {
		this.scId = scId;
	}

	public String getScName() {
		return this.scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	public String getSgId() {
		return this.sgId;
	}

	public void setSgId(String sgId) {
		this.sgId = sgId;
	}

	public String getItId() {
		return this.itId;
	}

	public void setItId(String itId) {
		this.itId = itId;
	}

	public Timestamp getScCreateTime() {
		return this.scCreateTime;
	}

	public void setScCreateTime(Timestamp scCreateTime) {
		this.scCreateTime = scCreateTime;
	}

	public String getScState() {
		return this.scState;
	}

	public void setScState(String scState) {
		this.scState = scState;
	}

	public SchoolGrade getSchoolGrade() {
		return schoolGrade;
	}

	public void setSchoolGrade(SchoolGrade schoolGrade) {
		this.schoolGrade = schoolGrade;
	}
	
	public List<InfoStudent> getStudent() {
		return student;
	}

	public void setStudent(List<InfoStudent> student) {
		this.student = student;
	}

	public InfoTeacher getInfoTeacher() {
		return infoTeacher;
	}

	public void setInfoTeacher(InfoTeacher infoTeacher) {
		this.infoTeacher = infoTeacher;
	}
	
}