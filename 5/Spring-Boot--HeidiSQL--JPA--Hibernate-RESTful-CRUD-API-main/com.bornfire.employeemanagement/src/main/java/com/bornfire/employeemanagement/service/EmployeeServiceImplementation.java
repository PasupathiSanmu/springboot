package com.bornfire.employeemanagement.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bornfire.employeemanagement.exception.ResourceNotFoundException;
import com.bornfire.employeemanagement.model.EmployeeModel;
import com.bornfire.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public List<EmployeeModel> getEmployees() {
		// TODO Auto-generated method stub
		return (List<EmployeeModel>) repo.findAll();
	}

	@Override
	public EmployeeModel addEmployee(EmployeeModel employees) {
		// TODO Auto-generated method stub
		return repo.save(employees);
	}

	@Override
	public EmployeeModel getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		return repo.findById(employeeId)
				.orElseThrow(()-> new ResourceNotFoundException("User not found with id: " +employeeId));
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}



}
