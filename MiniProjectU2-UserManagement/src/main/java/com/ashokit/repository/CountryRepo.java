package com.ashokit.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.Country;

public interface CountryRepo extends JpaRepository<Country, Integer> {
	
}
