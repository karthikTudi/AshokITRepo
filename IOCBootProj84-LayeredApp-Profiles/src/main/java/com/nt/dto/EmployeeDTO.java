package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {
	private String ename;
	private String eadd;
	private float netsalery;

}
