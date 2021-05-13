package com.akeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	public RegionalCouncil postRegionalCouncil(@RequestBody RegionalCouncil rc) {
		return regionalCouncilRepository.save(rc);
	}
	
	@PostMapping("/local-council/{regId}")
	public LocalCouncil postLocalCouncil(@PathVariable("regId") Long regId,@RequestBody LocalCouncil lc) {
		lc.setRegionalCouncil(regionalCouncilRepository.getOne(regId));
		return localCouncilRepository.save(lc);
	}
	
	@GetMapping("/regional-council")
	public List<RegionalCouncil> getRegionalCouncil() {
		return regionalCouncilRepository.findAll();
	}
	
	@GetMapping("/local-council/{rid}")
	public List<LocalCouncil> getLocalCouncil(@PathVariable("rid") Long rid) {
		return localCouncilRepository.findByRegionalCouncil(rid);
	}
	
	@DeleteMapping("/regional-council/{id}")
	public void deleteRegionalCouncil(@PathVariable("id") Long id) {
		regionalCouncilRepository.deleteById(id);
	}
	
	@DeleteMapping("/localCouncil/{id}")
	public void deleteLocalCouncil(@PathVariable("id") Long id) {
		localCouncilRepository.deleteById(id);
	}
}
