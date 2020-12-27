package com.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashokit.entity.City;

public interface CityRepo extends JpaRepository<City, Integer> {
	
	/*@Query("SELECT DISTINCT cityId,cityname FROM City WHERE stateid=:stateid")
	public List<City>getAllCities(Integer stateid);*/
	
	public List<City> findByStateid(Integer stateid);
	


}
