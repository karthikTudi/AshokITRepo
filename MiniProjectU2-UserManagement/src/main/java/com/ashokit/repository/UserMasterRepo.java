package com.ashokit.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.UserMaster;

public interface UserMasterRepo extends JpaRepository<UserMaster, Integer> {
	
	/*@Query("SELECT * from UserMaster WHERE email=:email")
	public UserMaster isEmailUniq(String email);*/
	
	public UserMaster findByEmail(String email);
	
	public  UserMaster findByEmailAndPwd(String email,String pwd);
	

}
