package com.akeb.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.akeb.model.Webinar;

@Service
public class WebinarService {

	public List<Webinar> filterUpcommingThreeWebinars(List<Webinar> list) {
		return list.stream()
				.filter(w-> LocalDate.parse(w.getDate()).compareTo(LocalDate.now()) >= 0)
				.limit(3)
				.collect(Collectors.toList());
		
	}

	public List<Webinar> filterRecentThreeWebinars(List<Webinar> list) {
		return list.stream()
				.filter(w-> LocalDate.parse(w.getDate()).compareTo(LocalDate.now()) < 0)
				.limit(3)
				.collect(Collectors.toList());
	}

	
}
