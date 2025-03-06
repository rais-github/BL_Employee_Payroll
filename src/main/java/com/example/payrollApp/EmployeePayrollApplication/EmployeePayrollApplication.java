package com.example.payrollApp.EmployeePayrollApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployeePayrollApplication {

	private static final Logger log = LoggerFactory.getLogger(EmployeePayrollApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeePayrollApplication.class, args);
		log.info("Employee Payroll application is running in {} Environment",
				context.getEnvironment().getProperty("environment"));
		log.info("Employee payroll Db user is {} ",context.getEnvironment().getProperty("spring.datasource.username"));
	}
}
