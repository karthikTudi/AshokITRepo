package com.ashokit.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "City_Table")
public class City implements Serializable  {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "City_Id")
	private Integer cityId;
	@Column(name = "City_name")
	private String cityname;
	/*	@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name ="State_Id" )*/
	private Integer stateid;

}
