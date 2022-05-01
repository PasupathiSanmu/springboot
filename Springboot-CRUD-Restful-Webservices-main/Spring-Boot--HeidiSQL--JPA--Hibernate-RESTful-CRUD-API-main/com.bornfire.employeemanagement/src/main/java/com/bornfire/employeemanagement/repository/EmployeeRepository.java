package com.bornfire.employeemanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bornfire.employeemanagement.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeModel, Long> {
}
