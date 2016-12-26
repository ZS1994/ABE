package com.abe.entity;

/**
 * PowerRolePermission entity. @author MyEclipse Persistence Tools
 */

public class PowerRolePermission implements java.io.Serializable {

	// Fields

	private String rpId;
	private String RId;
	private String PId;

	// Constructors

	/** default constructor */
	public PowerRolePermission() {
	}

	/** minimal constructor */
	public PowerRolePermission(String rpId) {
		this.rpId = rpId;
	}

	/** full constructor */
	public PowerRolePermission(String rpId, String RId, String PId) {
		this.rpId = rpId;
		this.RId = RId;
		this.PId = PId;
	}

	// Property accessors

	public String getRpId() {
		return this.rpId;
	}

	public void setRpId(String rpId) {
		this.rpId = rpId;
	}

	public String getRId() {
		return this.RId;
	}

	public void setRId(String RId) {
		this.RId = RId;
	}

	public String getPId() {
		return this.PId;
	}

	public void setPId(String PId) {
		this.PId = PId;
	}

}