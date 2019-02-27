package com.capgemini.mvc.dao;

import java.util.List;

import com.capgemini.mvc.model.Employee;

public interface EmployeeDAO {


	Employee findById(int employeeId);
	
	Employee findBySSN(String ssn);
	
	void saveEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployeeById(Integer employeeId);
	
	List findAllEmployees();

}
