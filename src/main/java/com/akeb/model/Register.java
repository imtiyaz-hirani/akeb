package com.akeb.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Register {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	AKEBUser user;
	
	@ManyToOne
    @JoinColumn(name = "webinar_id")
	Webinar webinar;
	
	private String registrationTimeStamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AKEBUser getUser() {
		return user;
	}

	public void setUser(AKEBUser user) {
		this.user = user;
	}

	public Webinar getWebinar() {
		return webinar;
	}

	public void setWebinar(Webinar webinar) {
		this.webinar = webinar;
	}

	public String getRegistrationTimeStamp() {
		return registrationTimeStamp;
	}

	public void setRegistrationTimeStamp(String registrationTimeStamp) {
		this.registrationTimeStamp = registrationTimeStamp;
	}
	
	
}
