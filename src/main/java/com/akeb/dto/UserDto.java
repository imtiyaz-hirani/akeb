package com.akeb.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDto {

private String email;
	
	private String name; 
	
	private String qualification;

	private String contact; 
	
	private String dob;
	
	private String isUpdate;
	
	private Long regionalCouncil;
	
	private Long localCouncil;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(String isUpdate) {
		this.isUpdate = isUpdate;
	}

	public Long getRegionalCouncil() {
		return regionalCouncil;
	}

	public void setRegionalCouncil(Long regionalCouncil) {
		this.regionalCouncil = regionalCouncil;
	}

	public Long getLocalCouncil() {
		return localCouncil;
	}

	public void setLocalCouncil(Long localCouncil) {
		this.localCouncil = localCouncil;
	}
	
	
}
