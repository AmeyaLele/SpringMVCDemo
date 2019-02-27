package com.capgemini.mvc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="DEPARTMENT")
public class Department {

	
	@Column(name="D_ID")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer departmentId;
	
	@Column(name="D_NAME" , unique=true)
	private String departmentName;
	
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
}
