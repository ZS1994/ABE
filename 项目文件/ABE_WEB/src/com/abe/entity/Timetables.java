package com.abe.entity;

import java.sql.Time;

/**
 * Timetables entity. @author MyEclipse Persistence Tools
 */

public class Timetables implements java.io.Serializable {

	// Fields

	private String TId;
	private Integer TWeek;
	private Integer TOrder;
	private String CId;
	private String itId;
	private Time TStartTime;
	private Time TEndTime;
	private String scId;

	
	private Course course;
	private SchoolClass schoolClass;
	private InfoTeacher infoTeacher;
	
	// Constructors

	/** default constructor */
	public Timetables() {
	}

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

	/** minimal constructor */
	public Timetables(String TId) {
		this.TId = TId;
	}

	/** full constructor */
	public Timetables(String TId, Integer TWeek, Integer TOrder, String CId,
			String itId, Time TStartTime, Time TEndTime, String scId) {
		this.TId = TId;
		this.TWeek = TWeek;
		this.TOrder = TOrder;
		this.CId = CId;
		this.itId = itId;
		this.TStartTime = TStartTime;
		this.TEndTime = TEndTime;
		this.scId = scId;
	}

	// Property accessors

	public String getTId() {
		return this.TId;
	}

	public void setTId(String TId) {
		this.TId = TId;
	}

	public Integer getTWeek() {
		return this.TWeek;
	}

	public void setTWeek(Integer TWeek) {
		this.TWeek = TWeek;
	}

	public Integer getTOrder() {
		return this.TOrder;
	}

	public void setTOrder(Integer TOrder) {
		this.TOrder = TOrder;
	}

	public String getCId() {
		return this.CId;
	}

	public void setCId(String CId) {
		this.CId = CId;
	}

	public String getItId() {
		return this.itId;
	}

	public void setItId(String itId) {
		this.itId = itId;
	}

	public Time getTStartTime() {
		return this.TStartTime;
	}

	public void setTStartTime(Time TStartTime) {
		this.TStartTime = TStartTime;
	}

	public Time getTEndTime() {
		return this.TEndTime;
	}

	public void setTEndTime(Time TEndTime) {
		this.TEndTime = TEndTime;
	}

	public String getScId() {
		return this.scId;
	}

	public void setScId(String scId) {
		this.scId = scId;
	}

}