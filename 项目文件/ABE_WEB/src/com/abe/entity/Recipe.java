package com.abe.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Recipe entity. @author MyEclipse Persistence Tools
 */

public class Recipe implements Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private String RId;
	private String scId;
	private String RType;
	private String RTime;
	private String RState;
	private String UId;
	private String RCreatTime;
	private String RStatus;
	private String RImages;
	private String RImagesUrl;
	private String isIdAccept;
	private String isIdAll;
//--------------------------------
	private SchoolClass schoolClass;
	private Users users;
	private List<InfoStudent> students;
	
	public String getRImagesUrl() {
		return RImagesUrl;
	}
	
	public void setRImagesUrl(String rImagesUrl) {
		RImagesUrl = rImagesUrl;
	}
	
	public SchoolClass getSchoolClass() {
		return schoolClass;
	}
	
	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}
	
	public Users getUsers() {
		return users;
	}
	
	public void setUsers(Users users) {
		this.users = users;
	}
	
	public List<InfoStudent> getStudents() {
		return students;
	}
	
	public void setStudents(List<InfoStudent> students) {
		this.students = students;
	}
	// Constructors

	/** default constructor */
	public Recipe() {
	}

	/** minimal constructor */
	public Recipe(String RId) {
		this.RId = RId;
	}

	/** full constructor */
	public Recipe(String RId, String scId, String RType, String RTime,
			String RState, String UId, String RCreatTime, String RStatus,
			String RImages,String RImagesUrl, String isIdAccept, String isIdAll) {
		this.RId = RId;
		this.scId = scId;
		this.RType = RType;
		this.RTime = RTime;
		this.RState = RState;
		this.UId = UId;
		this.RCreatTime = RCreatTime;
		this.RStatus = RStatus;
		this.RImages = RImages;
		this.RImagesUrl = RImagesUrl;
		this.isIdAccept = isIdAccept;
		this.isIdAll = isIdAll;
	}

	// Property accessors

	public String getRId() {
		return this.RId;
	}

	public void setRId(String RId) {
		this.RId = RId;
	}

	public String getScId() {
		return this.scId;
	}

	public void setScId(String scId) {
		this.scId = scId;
	}

	public String getRType() {
		return this.RType;
	}

	public void setRType(String RType) {
		this.RType = RType;
	}

	public String getRTime() {
		return this.RTime;
	}

	public void setRTime(String RTime) {
		this.RTime = RTime;
	}

	public String getRState() {
		return this.RState;
	}

	public void setRState(String RState) {
		this.RState = RState;
	}

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

	public String getRCreatTime() {
		return this.RCreatTime;
	}

	public void setRCreatTime(String RCreatTime) {
		this.RCreatTime = RCreatTime;
	}

	public String getRStatus() {
		return this.RStatus;
	}

	public void setRStatus(String RStatus) {
		this.RStatus = RStatus;
	}

	public String getRImages() {
		return this.RImages;
	}

	public void setRImages(String RImages) {
		this.RImages = RImages;
	}

	public String getIsIdAccept() {
		return this.isIdAccept;
	}

	public void setIsIdAccept(String isIdAccept) {
		this.isIdAccept = isIdAccept;
	}

	public String getIsIdAll() {
		return this.isIdAll;
	}

	public void setIsIdAll(String isIdAll) {
		this.isIdAll = isIdAll;
	}

}