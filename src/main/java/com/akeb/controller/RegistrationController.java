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
	public void postUser(@PathVariable("webinarId") Long webinarId, @RequestBody UserDto dto) {
		 AKEBUser user = convertDto(dto);
		 Webinar webinar = webinarRepository.getOne(webinarId);
		 Register register = new Register();
		 AKEBUser userDB = userRepository.findByEmail(user.getEmail());
		 if(userDB == null) {
			 user.setRegionalCouncil(regionalCouncilRepository.getOne(dto.getRegionalCouncil()));
			 user.setLocalCouncil(localCouncilRepository.getOne(dto.getLocalCouncil()));
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
	}
	
	@GetMapping("/user/webinar/registrations")
	public List<Register> getAllRegistrations() {
		return registerRepository.findAll();
	}
	
	private static AKEBUser convertDto(UserDto dto) {
		AKEBUser user = new AKEBUser();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setContact(dto.getContact());
		user.setDob(dto.getDob());
		user.setQualification(dto.getQualification());
		user.setIsUpdate(dto.getIsUpdate());
		return user;
	}
	
	@PostMapping("/user/webinar/questions/{wid}/{email}")
	public void postWebinarQuestions(@RequestBody QuestionDto dto, @PathVariable("wid") Long wid, 
			@PathVariable("email") String email) {
		
		Webinar webinar = webinarRepository.getOne(wid);
		AKEBUser user = userRepository.findByEmail(email);
		
		List<Answer> answerList = new ArrayList<>();
		
		dto.getQuestions().forEach(q->{
			Answer answer = new Answer();
			answer.setWebinar(webinar);
			answer.setUser(user);
			answer.setQuestionText(q.getQtext());
			answer.setAnswerText(q.getAns());
			
			answerList.add(answer);
		});
		
		ansRepository.saveAll(answerList);
	}
}
