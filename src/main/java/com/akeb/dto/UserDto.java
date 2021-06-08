package com.akeb.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDto {

    private String email;
	
	private String fName;
	
	private String mName;
	
	private String lName;
	
	private String qualification;

	private String contact; 
	
	private String dob;
	
	private String regionalCouncil;
	
	private String localCouncil;
	
	private String university;
	
	private String college;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getRegionalCouncil() {
		return regionalCouncil;
	}

	public void setRegionalCouncil(String regionalCouncil) {
		this.regionalCouncil = regionalCouncil;
	}

	public String getLocalCouncil() {
		return localCouncil;
	}

	public void setLocalCouncil(String localCouncil) {
		this.localCouncil = localCouncil;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	 
}
