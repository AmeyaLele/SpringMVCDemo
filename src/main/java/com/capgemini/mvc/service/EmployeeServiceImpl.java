package com.capgemini.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.mvc.dao.EmployeeDAO;
import com.capgemini.mvc.model.Employee;

@Service("employeeService")
@Transactional
@Component
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO dao;

	@Override
	public Employee findById(int employeeId) {
		// TODO Auto-generated method stub
		return dao.findById(employeeId);
	}

	@Override
	public void saveEmployee(Employee employee) {
		dao.saveEmployee(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		Employee entity = dao.findById(employee.getEmployeeId());
		
		if(entity!=null)
		{
			entity.setEmployeeName(employee.getEmployeeName());
			entity.setDateOfJoining(employee.getDateOfJoining());
			entity.setSalary(employee.getSalary());
		}				
	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {
		dao.deleteEmployeeById(employeeId);
		
	}

	@Override
	public List findAllEmployees() {
		// TODO Auto-generated method stub
		return dao.findAllEmployees();
	}

	@Override
	public boolean isSSNUnique(Integer id, String ssn) {
		
		Employee employee = findBySSN(ssn);		
		return (employee==null||(id!=null) && employee.getEmployeeId()==(id));
	}

	@Override
	public Employee findBySSN(String ssn) {		
		return dao.findBySSN(ssn);
	}

	
	

}
