package com.capgemini.mvc.model;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.springframework.format.annotation.DateTimeFormat;


@Entity(name="EMPLOYEE")
public class Employee {

	@Id
	@Column(name="E_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
	
	@Column(name="SSN", nullable=false, unique=true)
	private String ssn;
	
	@Column(name="E_NAME",nullable=false)
	private String employeeName;
	
	@Column(name="E_DOJ" ,nullable=false)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateOfJoining;
	
	@Column(name="SALARY")
	private Integer salary;
	
	@ManyToOne
	@JoinColumn(name="D_ID")
	private Department department;
	

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	 @Override
	 public String toString() {
	 
	     return "Employee [id=" + employeeId + ", name=" + employeeName + ", joiningDate="
	              + dateOfJoining + ", salary=" + salary + ", ssn=" + ssn + "]";
	     
	     }
	 
	  

}
