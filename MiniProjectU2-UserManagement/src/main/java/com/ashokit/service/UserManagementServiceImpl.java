package com.ashokit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.City;
import com.ashokit.entity.Country;
import com.ashokit.entity.State;
import com.ashokit.entity.UserMaster;
import com.ashokit.repository.CityRepo;
import com.ashokit.repository.CountryRepo;
import com.ashokit.repository.StateRepo;
import com.ashokit.repository.UserMasterRepo;

@Service
public class UserManagementServiceImpl implements IUserManagement {

	@Autowired
	private UserMasterRepo userrepo;
	@Autowired
	private CountryRepo countryrepo;
	@Autowired
	private StateRepo staterepo;
	@Autowired
	private CityRepo cityrepo;

	@Override
	public Map<Integer, String> findContries() {
		List<Country> listcountries = countryrepo.findAll();
		Map<Integer, String> countries = new HashMap<Integer, String>();
		listcountries.forEach(country -> {
			countries.put(country.getCountryid(), country.getCountryname());
		});
		return countries;
	}

	public Map<Integer, String> findStates(Integer countryid) {
		List<State> liststates = staterepo.findByCountryId(countryid);
		//List<State> liststates = staterepo.getAllStates(countryid);
		Map<Integer, String> states = new HashMap<Integer, String>();
		liststates.forEach(state -> {
			states.put(state.getStateid(), state.getStatename());
		});
		return states;
	}

	@Override
	public Map<Integer, String> findCities(Integer stateid) {
		//List<City> listcities = cityrepo.getAllCities(stateid);
		List<City> listcities = cityrepo.findByStateid(stateid);
		Map<Integer, String> cities = new HashMap<Integer, String>();
		listcities.forEach(city -> {
			cities.put(city.getCityId(), city.getCityname());
		});
		return cities;
	}

	// type1: if email present userdetails have value and returns true otherwise
	// false
	@Override
	public boolean isEmailUnique(String email) {
		UserMaster userdetails = userrepo.findByEmail(email);
		if (userdetails == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean SaveUser(UserMaster master) {
		master.setPwd(generatePassayPassword());
		master.setAcstatus("LOCKED");
		UserMaster userdetails = userrepo.save(master);
		return userdetails.getUserid() != null;
	}

	// generate random password
	public String generatePassayPassword() {
		char[] password = new char[5];// to tell that generate only 5 character password
		Random ranpwd = new Random();// to take any random value
		String alphanumeric = "ABCDEFGabcdefg123456";// with this values only generate password
		for (int i = 0; i < 5; i++) {
			password[i] = alphanumeric.charAt(ranpwd.nextInt(alphanumeric.length()));
		}
		System.out.println(password.toString());
		return password.toString();
	}

	// TYPE1: entered both wrong email and password return invalid creadentials
	// type2:entered correct details but Account locked then return Please Unlock
	// your Account by going to your Gmail
	// type3:entered correct details but Account Unlocked then return Welcome with
	// username
	@Override
	public String LoginCheck(String email, String pwd) {
		UserMaster master = userrepo.findByEmailAndPwd(email, pwd);
		if (master != null) {
			if (master.getAcstatus().equalsIgnoreCase("LOCKED")) {
				return "Please Unlock  your Account by going to your Gmail";
			} else {
				return "Welcome  " + master.getLname();
			}
		}
		return "INVALID_CREDENTIALS";
	}

	// UNLOCK Account Operations
	@Override
	public boolean isTempPwdvalid(String email, String tpwd) {
		UserMaster user = userrepo.findByEmailAndPwd(email, tpwd);
		if (user == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean unlockAccount(String email, String npwd) {
		UserMaster user = userrepo.findByEmail(email);
		user.setPwd(npwd);
		user.setAcstatus("UNLOCKED");
		try {
			UserMaster userdetails = userrepo.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
/*
 * test1:if email is wrong returns null
 * test2:if email is present it will return the password
 */
	@Override
	public String forgotPassword(String email) {
		UserMaster userdetails = userrepo.findByEmail(email);
		if(userdetails!=null) {
			return userdetails.getPwd();
		}
		return null;
	}
}
