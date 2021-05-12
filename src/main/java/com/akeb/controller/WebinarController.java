package com.akeb.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akeb.dto.WebinarDto;
import com.akeb.model.Webinar;
import com.akeb.model.WebinarCategory;
import com.akeb.repository.WebinarCategoryRepository;
import com.akeb.repository.WebinarRepository;
import com.akeb.service.WebinarService;

@RestController
public class WebinarController {

	@Autowired
	private WebinarRepository webinarRepository;
	
	@Autowired
	private WebinarService webinarService;
	
	@Autowired
	private WebinarCategoryRepository webinarCategoryRepository;
	/*
	 * 3 upcoming webinar details
	 * 3 concluded webinar details
	 */
	@GetMapping("/webinars")
	public WebinarDto getWebinarforDashboard() {
		List<Webinar> list = this.webinarRepository.findAll();
		List<Webinar> upcommingList = this.webinarService.filterUpcommingThreeWebinars(list);
		List<Webinar> recentList = this.webinarService.filterRecentThreeWebinars(list);
		Collections.sort(upcommingList);
		Collections.sort(recentList);
		
		WebinarDto dto = new WebinarDto();
		dto.setUpcomingWebinars(upcommingList);
		dto.setRecentlyConcludedWebinars(recentList);
		return dto;
	}
	
	@PostMapping("/webinar/{catId}")
	public void postWebinar(@PathVariable("catId") Long catId, @RequestBody Webinar webinar) {
		WebinarCategory category = this.webinarCategoryRepository.getOne(catId);
		webinar.setWebinarCategory(category);
		webinarRepository.save(webinar);
	}
	
	@PostMapping("/webinar-category")
	public void postWebinarCategory(@RequestBody WebinarCategory category) {
		webinarCategoryRepository.save(category);
	}
	
	
}














