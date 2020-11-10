package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDao;
import com.nt.dto.EmployeeDTO;

@Service("empservice")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;

	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl::0-param constructor");
	}

	@Override
	public String GenearateTotalSalery(EmployeeDTO dto) throws Exception {
		float gsalery = 0.0f;
		float netsalery = 0.0f;
		float Taxes = 0.0f;
		EmployeeBO bo = null;
		int cnt = 0;
		netsalery = dto.getNetsalery();
		// calculate gross salery
		gsalery = netsalery + (0.3f * netsalery);
		// calculate Taxes
		Taxes = (gsalery * 0.1f);
		// create BO class object
		bo = new EmployeeBO();
		// assign persistent values to BO
		bo.setEadd(dto.getEadd());
		bo.setEname(dto.getEname());
		bo.setNetsalery(dto.getNetsalery());
		bo.setGsalery(gsalery);
		bo.setTaxes(Taxes);
		cnt = dao.insertEmployeesaleryDetails(bo);
		if (cnt == 0)
			return "Employee Salery Calculatiuon failed";
		else
			return "Employee Salery Calculation success and Employee GSaler" + gsalery + "Netsalery:" + netsalery
					+ " Taxes are:" + Taxes;
	}// method

}// class
