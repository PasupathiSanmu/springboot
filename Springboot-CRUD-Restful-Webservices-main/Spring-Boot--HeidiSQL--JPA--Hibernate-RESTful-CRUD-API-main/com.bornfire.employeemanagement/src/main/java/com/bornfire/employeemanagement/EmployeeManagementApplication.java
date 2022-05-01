package com.bornfire.employeemanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);

		System.out.println("Spring project for Employee Management System");

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
