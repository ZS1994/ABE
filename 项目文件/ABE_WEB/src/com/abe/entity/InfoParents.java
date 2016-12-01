package com.abe.entity;

import java.util.Date;

/**
 * InfoParents entity. @author MyEclipse Persistence Tools
 */

public class InfoParents implements java.io.Serializable {

	// Fields

	private String ipId;
	private String ipName;
	private String ipSex;
	private Date ipBirthday;
	private String ipPhone;
	private String ipAddress;

	// Constructors
	private String spRelation;
	
	
	public String getSpRelation() {
		return spRelation;
	}

	public void setSpRelation(String spRelation) {
		this.spRelation = spRelation;
	}

	/** default constructor */
	public InfoParents() {
	}

	/** minimal constructor */
	public InfoParents(String ipId) {
		this.ipId = ipId;
	}

	/** full constructor */
	public InfoParents(String ipId, String ipName, String ipSex,
			Date ipBirthday, String ipPhone, String ipAddress) {
		this.ipId = ipId;
		this.ipName = ipName;
		this.ipSex = ipSex;
		this.ipBirthday = ipBirthday;
		this.ipPhone = ipPhone;
		this.ipAddress = ipAddress;
	}

	// Property accessors

	public String getIpId() {
		return this.ipId;
	}

	public void setIpId(String ipId) {
		this.ipId = ipId;
	}

	public String getIpName() {
		return this.ipName;
	}

	public void setIpName(String ipName) {
		this.ipName = ipName;
	}

	public String getIpSex() {
		return this.ipSex;
	}

	public void setIpSex(String ipSex) {
		this.ipSex = ipSex;
	}

	public Date getIpBirthday() {
		return this.ipBirthday;
	}

	public void setIpBirthday(Date ipBirthday) {
		this.ipBirthday = ipBirthday;
	}

	public String getIpPhone() {
		return this.ipPhone;
	}

	public void setIpPhone(String ipPhone) {
		this.ipPhone = ipPhone;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}