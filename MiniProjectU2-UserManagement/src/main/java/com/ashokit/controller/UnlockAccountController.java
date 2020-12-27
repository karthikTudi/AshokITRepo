package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.service.UserManagementServiceImpl;

@RestController
@RequestMapping("/unlockuser")
public class UnlockAccountController {

	@Autowired
	private UserManagementServiceImpl service;

	@PostMapping("/unlockaccount")
	public ResponseEntity<String> tempPwdCheck(@RequestParam String email,@RequestParam String tpwd,
																									@RequestParam String npwd) {
		if(service.isTempPwdvalid(email, tpwd)) {
			 if(service.unlockAccount(email, npwd)) {
				 return new ResponseEntity<String>("Unlocked SuccessFully",HttpStatus.CREATED);
			 }
			 return new ResponseEntity<String>("Unlocking Failed",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Entered Temporary Password is Wrong",HttpStatus.CREATED);
	}
}
