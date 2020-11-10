package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;
import com.nt.vo.EmployeeVO;

@Controller("empcontroller")
public class MyController {
	@Autowired
	private EmployeeService service;

	public MyController() {
		System.out.println("MyController::0-param constructor");
	}

	public String GetEmployeeSaleryDetails(EmployeeVO vo) throws Exception {
		EmployeeDTO dto = null;
		String result = null;
		// convert the Vo class to DTO
		dto = new EmployeeDTO();
		dto.setEname(vo.getEname());
		dto.setEadd(vo.getEadd());
		dto.setNetsalery(Integer.parseInt(vo.getNetsalery()));
		result = service.GenearateTotalSalery(dto);
		return result;
	}
}// classs
