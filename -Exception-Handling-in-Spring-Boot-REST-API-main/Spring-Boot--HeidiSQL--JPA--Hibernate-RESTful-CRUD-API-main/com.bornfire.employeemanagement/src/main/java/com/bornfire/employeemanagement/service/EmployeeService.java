package com.bornfire.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import com.bornfire.employeemanagement.model.EmployeeModel;

public interface EmployeeService {

	List<EmployeeModel> getEmployees();

	EmployeeModel addEmployee(EmployeeModel employees);

	EmployeeModel getEmployeeById(Long employeeId);

	void deleteEmployee(long id);
}
