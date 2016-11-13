package com.abe.entity;

import java.sql.Time;
import java.util.Date;

/**
 * Timetables entity. @author MyEclipse Persistence Tools
 */

public class Timetables implements java.io.Serializable {

	// Fields

	private String TId;
	private String CId;
	private String scId;
	private String itId;
	private Time TStartTime;
	private Time TEndTime;
	private Date TDate;
	private Integer TOrder;

	
	private Course course;
	private SchoolClass schoolClass;
	private InfoTeacher infoTeacher;
	
	
	
	// Constructors

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public SchoolClass getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}

	public InfoTeacher getInfoTeacher() {
		return infoTeacher;
	}

	public void setInfoTeacher(InfoTeacher infoTeacher) {
		this.infoTeacher = infoTeacher;
	}

	/** default constructor */
	public Timetables() {
	}

	/** minimal constructor */
	public Timetables(String TId) {
		this.TId = TId;
	}

	/** full constructor */
	public Timetables(String TId, String CId, String scId, String itId,
			Time TStartTime, Time TEndTime, Date TDate, Integer TOrder) {
		this.TId = TId;
		this.CId = CId;
		this.scId = scId;
		this.itId = itId;
		this.TStartTime = TStartTime;
		this.TEndTime = TEndTime;
		this.TDate = TDate;
		this.TOrder = TOrder;
	}

	// Property accessors

	public String getTId() {
		return this.TId;
	}

	public void setTId(String TId) {
		this.TId = TId;
	}

	public String getCId() {
		return this.CId;
	}

	public void setCId(String CId) {
		this.CId = CId;
	}

	public String getScId() {
		return this.scId;
	}

	public void setScId(String scId) {
		this.scId = scId;
	}

	public String getItId() {
		return this.itId;
	}

	public void setItId(String itId) {
		this.itId = itId;
	}

	public java.sql.Time getTStartTime() {
		return this.TStartTime;
	}

	public void setTStartTime(java.sql.Time TStartTime) {
		this.TStartTime = TStartTime;
	}

	public java.sql.Time getTEndTime() {
		return this.TEndTime;
	}

	public void setTEndTime(java.sql.Time TEndTime) {
		this.TEndTime = TEndTime;
	}

	public java.util.Date getTDate() {
		return this.TDate;
	}

	public void setTDate(java.util.Date TDate) {
		this.TDate = TDate;
	}

	public Integer getTOrder() {
		return this.TOrder;
	}

	public void setTOrder(Integer TOrder) {
		this.TOrder = TOrder;
	}

	@Override
	public String toString() {
		return "Timetables [CId=" + CId + ", TDate=" + TDate + ", TEndTime="
				+ TEndTime + ", TId=" + TId + ", TOrder=" + TOrder
				+ ", TStartTime=" + TStartTime + ", course=" + course
				+ ", infoTeacher=" + infoTeacher + ", itId=" + itId + ", scId="
				+ scId + ", schoolClass=" + schoolClass + "]";
	}

	

}