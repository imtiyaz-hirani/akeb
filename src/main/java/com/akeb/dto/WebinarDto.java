package com.akeb.dto;

import java.util.List;

import com.akeb.model.Webinar;

public class WebinarDto {

	private List<Webinar> upcomingWebinars;
	
	private List<Webinar> recentlyConcludedWebinars;

	public List<Webinar> getUpcomingWebinars() {
		return upcomingWebinars;
	}

	public void setUpcomingWebinars(List<Webinar> upcomingWebinars) {
		this.upcomingWebinars = upcomingWebinars;
	}

	public List<Webinar> getRecentlyConcludedWebinars() {
		return recentlyConcludedWebinars;
	}

	public void setRecentlyConcludedWebinars(List<Webinar> recentlyConcludedWebinars) {
		this.recentlyConcludedWebinars = recentlyConcludedWebinars;
	}
	
	
}
