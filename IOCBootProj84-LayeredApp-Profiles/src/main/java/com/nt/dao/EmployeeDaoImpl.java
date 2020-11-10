package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empdao")
@Profile(value = { "uat", "prod", "dev", "test" })
public class EmployeeDaoImpl implements EmployeeDao {
	private static final String INSERT_EMPLOYEE_QUERY = "INSERT INTO LAYERED_EMPLOYEE VALUES(LAYERED_EMP_SEQ.NEXTVAL,?,?,?,?,?)";
	@Autowired
	private DataSource ds;

	public EmployeeDaoImpl() {
		System.out.println("EmployeeDaoImpl::0-param constructor");
	}

	@Override
	public int insertEmployeesaleryDetails(EmployeeBO bo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;
		// create connection object
		con = ds.getConnection();
		System.out.println(ds.getClass().getName());
		// create prepare statement
		ps = con.prepareStatement(INSERT_EMPLOYEE_QUERY);
		// set the values to the preparedStatement
		ps.setString(1, bo.getEname());
		ps.setString(2, bo.getEadd());
		ps.setFloat(3, bo.getGsalery());
		ps.setFloat(4, bo.getNetsalery());
		ps.setFloat(5, bo.getTaxes());
		// execute the query
		count = ps.executeUpdate();
		return count;
	}
}
