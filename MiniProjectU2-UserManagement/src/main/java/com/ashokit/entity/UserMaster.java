package com.ashokit.entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "UserMaster_Tab")
public class UserMaster implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "User_Id")
	private Integer userid;
	@Column(name = "fname",nullable = false)
	private String fname;
	@Column(name = "lname",nullable = false)
	private String lname;
	@Column(name = "email")
	private String email;
	@Column(name = "mobileno")
	private String mobileno;
	@Column(name = "dob")
	private Date dob;
	@Column(name = "genders")
	private String gender;
	@Column(name = "country")
	private Integer country;
	@Column(name = "state")
	private Integer state;
	@Column(name = "city")
	private Integer city;
	@Column(name = "pwd")
	private String pwd;
	@Column(name = "ac_status")
	private String acstatus;
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Integer getCountry() {
		return country;
	}
	public void setCountry(Integer country) {
		this.country = country;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getCity() {
		return city;
	}
	public void setCity(Integer city) {
		this.city = city;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAcstatus() {
		return acstatus;
	}
	public void setAcstatus(String acstatus) {
		this.acstatus = acstatus;
	}
}
