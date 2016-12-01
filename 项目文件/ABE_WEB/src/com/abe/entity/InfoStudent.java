package com.abe.entity;

import java.util.Date;
import java.util.List;

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
	private Integer isLocal;
	private Integer isTeacherChildren;
	private Date isIntoDate;
	private Date isLeaveDate;
	private String isState;
	private String scId;

	// Constructors
	private List<Score> scores;
	private SchoolClass schoolClass;
	private List<InfoParents> parents;
	private List<CardLog> cardLogs;

	
	
	public List<CardLog> getCardLogs() {
		return cardLogs;
	}
	public void setCardLogs(List<CardLog> cardLogs) {
		this.cardLogs = cardLogs;
	}
	public List<Score> getScores() {
		return scores;
	}
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	public SchoolClass getSchoolClass() {
		return schoolClass;
	}
	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}
	public List<InfoParents> getParents() {
		return parents;
	}
	public void setParents(List<InfoParents> parents) {
		this.parents = parents;
	}

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
			Date isBirthday, Integer isLocal, Integer isTeacherChildren,
			Date isIntoDate, Date isLeaveDate, String isState, String scId) {
		this.isId = isId;
		this.isNum = isNum;
		this.isName = isName;
		this.isSex = isSex;
		this.isBirthday = isBirthday;
		this.isLocal = isLocal;
		this.isTeacherChildren = isTeacherChildren;
		this.isIntoDate = isIntoDate;
		this.isLeaveDate = isLeaveDate;
		this.isState = isState;
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

	public String getScId() {
		return this.scId;
	}

	public void setScId(String scId) {
		this.scId = scId;
	}

}