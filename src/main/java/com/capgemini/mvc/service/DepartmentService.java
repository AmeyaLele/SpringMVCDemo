package com.capgemini.mvc.service;

import java.util.List;

import com.capgemini.mvc.model.Department;

public interface DepartmentService {

	Department findByID(int departmentId);
	
	Department findByName(String deptName);
	
	List<Department> findAll();
	
	List<String> findAllDepartmentNam();
	
	void saveDepartment(Department department);
	
	void updateDepartment(Department department);
	
	void deleteDepartment(Department department);
	
	
}
