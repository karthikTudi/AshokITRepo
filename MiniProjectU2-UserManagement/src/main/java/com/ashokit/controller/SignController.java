package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.service.UserManagementServiceImpl;

@RestController
@RequestMapping("/signinuser")
public class SignController {

	@Autowired
	private UserManagementServiceImpl service;

	@GetMapping("/signin")
	public ResponseEntity<String> validateUserDetails(@RequestParam String email, @RequestParam String password) {
		
		try {
			String msg = service.LoginCheck(email, password);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Log in Failed", HttpStatus.BAD_REQUEST);
		}
	}
}
