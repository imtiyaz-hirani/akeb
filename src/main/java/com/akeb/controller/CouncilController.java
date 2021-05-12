package com.akeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akeb.model.LocalCouncil;
import com.akeb.model.RegionalCouncil;
import com.akeb.repository.LocalCouncilRepository;
import com.akeb.repository.RegionalCouncilRepository;

@RestController
public class CouncilController {

	@Autowired
	private RegionalCouncilRepository regionalCouncilRepository;
	
	@Autowired
	private LocalCouncilRepository localCouncilRepository;
	
	@PostMapping("/regional-council")
	public void postRegionalCouncil(@RequestBody RegionalCouncil rc) {
		regionalCouncilRepository.save(rc);
	}
	
	@PostMapping("/local-council/{regId}")
	public void postLocalCouncil(@PathVariable("regId") Long regId,@RequestBody LocalCouncil lc) {
		lc.setRegionalCouncil(regionalCouncilRepository.getOne(regId));
		localCouncilRepository.save(lc);
	}
}
