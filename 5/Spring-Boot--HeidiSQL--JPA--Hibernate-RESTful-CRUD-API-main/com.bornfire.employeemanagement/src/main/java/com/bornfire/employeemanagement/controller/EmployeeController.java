package com.bornfire.employeemanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bornfire.employeemanagement.model.EmployeeModel;
import com.bornfire.employeemanagement.repository.EmployeeRepository;
import com.bornfire.employeemanagement.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@Autowired
	private EmployeeRepository repo;

	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeModel>> getEmployees() {
		List<EmployeeModel> employee = service.getEmployees();
		return new ResponseEntity<List<EmployeeModel>>(employee, HttpStatus.OK);

	}

	@GetMapping("/employee/{id}")

	public ResponseEntity<EmployeeModel> getEmployee(@PathVariable(value = "id") Long employeeId) {
		EmployeeModel employee = service.getEmployeeById(employeeId);

		return new ResponseEntity<EmployeeModel>(employee, HttpStatus.OK);

	}

	@PostMapping("/employee")
	public ResponseEntity<EmployeeModel> addEmployee(@RequestBody EmployeeModel employees) {
		EmployeeModel employee = service.addEmployee(employees);
		return new ResponseEntity<EmployeeModel>(employee, HttpStatus.OK);

	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@RequestBody EmployeeModel employees) {
		EmployeeModel employee = service.getEmployeeById(employeeId);
		employee.setEmployeeId(employees.getEmployeeId());
		employee.setEmployeeName(employees.getEmployeeName());
		employee.setDepartmentname(employees.getDepartmentname());
		employee.setSalary(employees.getSalary());
		// use obj.get() syntax to pick the value of Optional type
		EmployeeModel updateEmployee = repo.save(employee);
		return new ResponseEntity<EmployeeModel>(updateEmployee, HttpStatus.OK);

	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {

		service.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);

	}

	@GetMapping("/allemployee")
	public ResponseEntity<List<EmployeeModel>> getAllEmployeesDetails() {
		List<EmployeeModel> employee = repo.getAllRecords();
		return new ResponseEntity<List<EmployeeModel>>(employee, HttpStatus.OK);

	}

}
