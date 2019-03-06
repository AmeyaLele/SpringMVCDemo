package com.capgemini.mvc.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capgemini.mvc.model.Department;
import com.capgemini.mvc.model.Employee;
import com.capgemini.mvc.service.DepartmentService;
import com.capgemini.mvc.service.EmployeeService;

@Controller
@RequestMapping(name="/")
@ComponentScan(basePackages={"com.capgemini.mvc.*"})
public class AppController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value={"/","/list"},method=RequestMethod.GET)
	public String getEmployeeList(ModelMap map)
	{
		List employees = employeeService.findAllEmployees();
		map.addAttribute("employees", employees);
		return "allEmployees";
	}
			
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String addEmployee(ModelMap map)
	{
		Employee employee = new Employee();
		List<Department> departmentList = departmentService.findAll();
		map.addAttribute("employee", employee);
		map.addAttribute("deptList", departmentList);
		map.addAttribute("edit", false);
		return "registration";
	}

	
	@RequestMapping(value="/new" , method=RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute("employee")Employee employee , BindingResult result , ModelMap map )
	{	
		Department department=new Department();
		
		 if (result.hasErrors()) {			 
			 return "registration";
		 }
		 
		 if(!employeeService.isSSNUnique(employee.getEmployeeId(), employee.getSsn()))
		 {
			 FieldError ssnError = new FieldError("employee", "SSN", messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
			 result.addError(ssnError);
			 return "registration";
		 }
	
		 employeeService.saveEmployee(employee);
		 
		 map.addAttribute("success", "Employee "+employee.getEmployeeName()+" registered successfully");
		 
		 return "success";
	}
	
	
}