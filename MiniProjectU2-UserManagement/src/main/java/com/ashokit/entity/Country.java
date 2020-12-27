package com.ashokit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CountryMaster_Table")
public class Country implements Serializable {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "Country_Id")
	private Integer countryid;
	@Column(name = "Country_name")
	private String countryname;

}