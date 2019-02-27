package com.capgemini.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.capgemini.mvc.service.DepartmentService;
import com.capgemini.mvc.service.DepartmentServiceImpl;

@Component
//@ComponentScan(basePackages={"com.capgemini.mvc.*"})
public class DeptNameToDeptConverter implements Converter<String, Department>{
	
	@Autowired
	private DepartmentService departmentService;
	
	public DeptNameToDeptConverter(){
		
	}
	
	public DeptNameToDeptConverter(DepartmentService departmentService){
		this.departmentService =departmentService ;
	}
	
	@Override
	public Department convert(String source){
	
		return departmentService.findByID(Integer.parseInt(source));
	}

}
