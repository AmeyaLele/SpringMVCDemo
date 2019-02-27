package com.capgemini.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.mvc.dao.DepartmentDAO;
import com.capgemini.mvc.model.Department;

@Service("departmentService")
@Transactional
@Component
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDAO dao;
	
	@Override
	public Department findByID(int departmentId) {
	
		return dao.findByID(departmentId);
	}

	@Override
	public Department findByName(String departmentName) {
		
		return dao.findByName(departmentName);
	}

	@Override
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		dao.saveDepartment(department);

	}

	@Override
	public void updateDepartment(Department department) {

		Department record = dao.findByID(department.getDepartmentId());
		if(record!=null)
			dao.updateDepartment(department);

	}

	@Override
	public void deleteDepartment(Department department) {
	}

	@Override
	public List<Department> findAll(){
		return dao.findAll();
	}

	@Override
	public List<String> findAllDepartmentNam() {
		// TODO Auto-generated method stub
		return dao.findAllDepartmentName();
	}
}
