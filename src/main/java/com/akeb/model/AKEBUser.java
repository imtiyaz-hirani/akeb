package com.akeb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AKEBUser {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String email;
	
	private String name; 
	
	private String qualification;

	private String contact; 
	
	private String dob;
	
	private String isUpdate; 
	
	@OneToOne
	private RegionalCouncil regionalCouncil; 
	
	@OneToOne
	private LocalCouncil localCouncil; 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	
	public RegionalCouncil getRegionalCouncil() {
		return regionalCouncil;
	}

	public void setRegionalCouncil(RegionalCouncil regionalCouncil) {
		this.regionalCouncil = regionalCouncil;
	}

	public LocalCouncil getLocalCouncil() {
		return localCouncil;
	}

	public void setLocalCouncil(LocalCouncil localCouncil) {
		this.localCouncil = localCouncil;
	}

	@Override
	public String toString() {
		return "AKEBUser [id=" + id + ", email=" + email + ", name=" + name + ", qualification=" + qualification
				+ ", contact=" + contact + ", dob=" + dob + ", isUpdate=" + isUpdate + ", regionalCouncil="
				+ regionalCouncil + ", localCouncil=" + localCouncil + "]";
	}

	 
	 
	
	
	
}
