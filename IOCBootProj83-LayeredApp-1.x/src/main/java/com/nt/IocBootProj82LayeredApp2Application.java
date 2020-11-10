package com.nt;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.MyController;
import com.nt.vo.EmployeeVO;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
public class IocBootProj82LayeredApp2Application {

	public IocBootProj82LayeredApp2Application() {
		System.out.println("IocBootProj82LayeredApp2Application::o-param constructor");
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = null;
		MyController controller = null;
		EmployeeVO vo = null;
		Scanner scan = null;
		String name = null, add = null, salery = null;
		// create IOC container
		ctx = SpringApplication.run(IocBootProj82LayeredApp2Application.class, args);
		// get the Target class object
		controller = ctx.getBean("empcontroller", MyController.class);
		scan = new Scanner(System.in);
		System.out.println("Enter employee name");
		name = scan.next();
		System.out.println("Enter employee addrs");
		add = scan.next();
		System.out.println("Enter employee Salery");
		salery = scan.next();
		// create VO class object
		vo = new EmployeeVO();
		// assign values to the class object
		vo.setEname(name);
		vo.setEadd(add);
		vo.setNetsalery(salery);
		// invoke the method
		try {
			System.out.println(controller.GetEmployeeSaleryDetails(vo));
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close the straems
			if (scan != null)
				scan.close();
			//close container
			ctx.close();
		}
	}// main
}// class
