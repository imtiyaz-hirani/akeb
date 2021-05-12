package com.akeb.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Webinar implements Comparable<Webinar>{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String title;
	
	 
	@Column(length = 4000)
	private String description; 
	
	private String image; 
	
	private String date;
	
	private String day;

	private String time; 
	
	private String speakers;
	
	@OneToOne
	private WebinarCategory webinarCategory;
	
	
	 
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getDay() {
		return day;
	}



	public void setDay(String day) {
		this.day = day;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public String getSpeakers() {
		return speakers;
	}



	public void setSpeakers(String speakers) {
		this.speakers = speakers;
	}



	public WebinarCategory getWebinarCategory() {
		return webinarCategory;
	}



	public void setWebinarCategory(WebinarCategory webinarCategory) {
		this.webinarCategory = webinarCategory;
	}



	@Override
	public int compareTo(Webinar w) {
		LocalDate date2 = LocalDate.parse(this.date);
		LocalDate date1 = LocalDate.parse(w.date); 
		int cmp = (date1.getYear() - date2.getYear());
	    if (cmp == 0) {
	        cmp = (date1.getMonthValue() - date2.getMonthValue());
	        if (cmp == 0) {
	            cmp = (date1.getDayOfMonth() - date2.getDayOfMonth());
	        }
	    }
	    return cmp;
	}

	 
	
	
	
}
