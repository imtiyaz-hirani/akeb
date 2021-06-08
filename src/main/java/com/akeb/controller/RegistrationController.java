package com.akeb.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akeb.dto.QuestionDto;
import com.akeb.dto.UserDto;
import com.akeb.exception.EmailDoesNotExistException;
import com.akeb.model.AKEBUser;
import com.akeb.model.Answer;
import com.akeb.model.Register;
import com.akeb.model.Webinar;
import com.akeb.repository.AKEBUserRepository;
import com.akeb.repository.AnswerRepository;
import com.akeb.repository.LocalCouncilRepository;
import com.akeb.repository.RegionalCouncilRepository;
import com.akeb.repository.RegisterRepository;
import com.akeb.repository.WebinarRepository;

@RestController
public class RegistrationController {

	@Autowired
	private  AKEBUserRepository userRepository;
	
	@Autowired
	private WebinarRepository webinarRepository;
	
	@Autowired
	private RegisterRepository registerRepository;
	
	@Autowired
	private RegionalCouncilRepository regionalCouncilRepository;
	
	@Autowired
	private LocalCouncilRepository localCouncilRepository;
	
	@Autowired
	private AnswerRepository ansRepository;
	
	@GetMapping("/user/{email}")
	public AKEBUser getUserDetails(@PathVariable("email") String email) {
		AKEBUser user = userRepository.findByEmailAddress(email);
		if(user == null) {
			throw new EmailDoesNotExistException("Email does not exist");
		}
		return user; 
	}
	
	@CrossOrigin()
	@PostMapping("/user/register/webinar/{webinarId}")
	public AKEBUser postUser(@PathVariable("webinarId") Long webinarId, @RequestBody UserDto dto) {
		 AKEBUser user = convertDto(dto);
		 Webinar webinar = webinarRepository.getOne(webinarId);
		 Register register = new Register();
		 AKEBUser userDB = userRepository.findByEmail(user.getEmail());
		 if(userDB == null) {
			  
			 register.setUser(userRepository.save(user));
		 }else {
			 register.setUser(userDB);
		 }
		 register.setWebinar(webinar);
		 register.setRegistrationTimeStamp(LocalDateTime.now().toString());
		 //check if already registered
		 Register isRegister = registerRepository.checkIfAlreadyRegistered(user.getEmail(), webinar.getId());
		 if(isRegister == null)
			 registerRepository.save(register);
		 return user;
	}
	
	@GetMapping("/user/webinar/registrations")
	public List<Register> getAllRegistrations() {
		return registerRepository.findAll();
	}
	
	private static AKEBUser convertDto(UserDto dto) {
		AKEBUser user = new AKEBUser();
		user.setfName(dto.getfName());
		user.setmName(dto.getmName());
		user.setlName(dto.getlName());
		user.setEmail(dto.getEmail());
		user.setContact(dto.getContact());
		user.setDob(dto.getDob());
		user.setQualification(dto.getQualification());
		user.setCollege(dto.getCollege());
		user.setUniversity(dto.getUniversity());
		user.setLocalCouncil(dto.getLocalCouncil());
		user.setRegionalCouncil(dto.getRegionalCouncil());
		 
		return user;
	}
	
	@PostMapping("/user/webinar/questions/{wid}/{uid}")
	public void postWebinarQuestions(@RequestBody Answer answer, @PathVariable("wid") Long wid, 
			@PathVariable("uid") Long uid) {
		
		Webinar webinar = webinarRepository.getOne(wid);
		AKEBUser user = userRepository.getOne(uid);
		answer.setWebinar(webinar);
		answer.setUser(user);
		
		ansRepository.save(answer);
	}
}
