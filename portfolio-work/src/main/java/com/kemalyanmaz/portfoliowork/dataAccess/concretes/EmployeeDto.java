package com.kemalyanmaz.portfoliowork.dataAccess.concretes;

import java.util.Date;

public class EmployeeDto {
	
	private long id;
	private String firstName;
	private String lastName;
	private String departmentName;
	private String departmentSummary;
	private double salary;
	private Date joiningDate;
	private String graduationName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentSummary() {
		return departmentSummary;
	}
	public void setDepartmentSummary(String departmentSummary) {
		this.departmentSummary = departmentSummary;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getGraduationName() {
		return graduationName;
	}
	public void setGraduationName(String graduationName) {
		this.graduationName = graduationName;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	
	

	
	
}
