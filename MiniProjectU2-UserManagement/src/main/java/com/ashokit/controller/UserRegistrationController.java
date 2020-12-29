package com.ashokit.controller;

import java.util.Map;

import org.apache.naming.factory.SendMailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.Country;
import com.ashokit.entity.UserMaster;
import com.ashokit.mail.MailService;
import com.ashokit.service.IUserManagement;

@RestController
@RequestMapping("/registeruser")
public class UserRegistrationController {

	@Autowired
	private IUserManagement service;

	@GetMapping("/countries")
	public Map<Integer, String> getAllCountry() {
		return service.findContries();
	}

	@GetMapping("/states/{countryid}")
	public Map<Integer, String> getAllStates(@PathVariable Integer countryid) {
		return service.findStates(countryid);
	}

	@GetMapping("/cities/{stateid}")
	public Map<Integer, String> getAllCities(@PathVariable Integer stateid) {
		return service.findCities(stateid);
	}

	@GetMapping("/emailcheck/{email}")
	public String checkUniqEmail(@PathVariable String email) {
		if (service.isEmailUnique(email)) {
			return "UNIQUE";
		}
		return "DUPLICATE";
	}

	@PostMapping(value = "/saveuser", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> userRegistration(@RequestBody UserMaster master) {
		if (service.isEmailUnique(master.getEmail())) {
			service.SaveUser(master);
			return new ResponseEntity<String>("Registration Success And goto ur mail to Unlock", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Registartion Failed", HttpStatus.BAD_REQUEST);
	}
}// class
