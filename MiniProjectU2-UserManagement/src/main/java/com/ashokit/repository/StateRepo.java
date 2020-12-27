package com.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashokit.entity.State;

public interface StateRepo extends JpaRepository<State, Integer> {

	/*@Query("SELECT  stateid,statename FROM State WHERE countryId=:countryid")
	  public List<State>getAllStates(Integer countryid);
	*/
	
	public List<State> findByCountryId(Integer countryId);
	
}
