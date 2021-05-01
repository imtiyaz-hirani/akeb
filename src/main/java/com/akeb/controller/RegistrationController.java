package com.akeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akeb.AKEBUserRepository;
import com.akeb.exception.EmailDoesNotExistException;
import com.akeb.model.AKEBUser;

@RestController
public class RegistrationController {

	@Autowired
	private  AKEBUserRepository userRepository;
	
	@GetMapping("/user/{email}")
	public AKEBUser getUserDetails(@PathVariable("email") String email) {
		AKEBUser user = userRepository.findByEmailAddress(email);
		if(user == null) {
			throw new EmailDoesNotExistException("Email does not exists");
		}
		return user; 
	}
	@CrossOrigin()
	@PostMapping("/user/webinar/register")
	public void postUser(@RequestBody AKEBUser user) {
		AKEBUser userDB = userRepository.findByEmail(user.getEmail());
		if(userDB != null) {
			
		}
		else {
			userRepository.save(user);
		}
	}
	
	@GetMapping("/user/webinar/registrations")
	public List<AKEBUser> getAllRegistrations() {
		return userRepository.findAll();
	}
}
