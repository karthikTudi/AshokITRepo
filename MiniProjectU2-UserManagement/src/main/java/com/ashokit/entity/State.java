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
@Table(name = "State_Table")
public class State implements Serializable {
	@Id
	@Column(name = "State_Id")
	private Integer stateid;
	@Column(name = "State_name")
	private String statename;
	/*	@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "Country_Id")*/
	private Integer countryId;
	
	

}
