package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.service.UserManagementServiceImpl;

@RestController
@RequestMapping("/forgotpassword")
public class ForgotPasswordController {
	
	@Autowired
	private UserManagementServiceImpl service;
	
	public ResponseEntity<String> forgotpassword(@RequestParam String email){
		 return new ResponseEntity<String>(service.forgotPassword(email),HttpStatus.FOUND);
	}

}
