package com.capgemini.mvc.service;

import java.util.List;

import com.capgemini.mvc.model.Employee;

public interface EmployeeService {

	Employee findById(int employeeId);
	
	Employee findBySSN(String ssn);
	
	void saveEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployeeById(Integer employeeId);
	
	List findAllEmployees();

	boolean isSSNUnique(Integer id , String ssn);
}
