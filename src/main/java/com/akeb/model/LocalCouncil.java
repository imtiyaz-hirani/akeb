package com.akeb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

 
@Entity
public class LocalCouncil {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@OneToOne
	private RegionalCouncil regionalCouncil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RegionalCouncil getRegionalCouncil() {
		return regionalCouncil;
	}

	public void setRegionalCouncil(RegionalCouncil regionalCouncil) {
		this.regionalCouncil = regionalCouncil;
	}

	@Override
	public String toString() {
		return "LocalCouncil [id=" + id + ", name=" + name + ", regionalCouncil=" + regionalCouncil + "]";
	}
	
	
}
