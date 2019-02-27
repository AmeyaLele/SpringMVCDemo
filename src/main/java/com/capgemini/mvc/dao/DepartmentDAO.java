package com.capgemini.mvc.dao;

import java.util.List;

import com.capgemini.mvc.model.Department;

public interface DepartmentDAO {

	public List<Department> findAll();
	
	public List<String> findAllDepartmentName();
	
	Department findByID(int departmentId);
	
	Department findByName(String departmentName);
	
	void saveDepartment(Department department);
	
	void updateDepartment(Department department);
	
	void deleteDepartment(Department department);
	
}
