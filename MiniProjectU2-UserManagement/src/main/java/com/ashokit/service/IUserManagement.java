package com.ashokit.service;

import java.util.Map;

import com.ashokit.entity.UserMaster;

public interface IUserManagement {
	
	//Registration page
	Map<Integer,String> findContries();
	Map<Integer,String> findStates(Integer countryid);
	Map<Integer,String> findCities(Integer stateid);
	public boolean isEmailUnique(String email);
	public boolean SaveUser(UserMaster master);
	
	//for Login Page operations
	public String LoginCheck(String email,String pwd);
	
	//unlock account page operations
	public boolean isTempPwdvalid(String email,String tpwd);
	public boolean unlockAccount(String email,String npwd);
	
	//forgot password page Operations
	public String forgotPassword(String email);
	
}
