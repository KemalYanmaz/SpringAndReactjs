package com.kemalyanmaz.portfoliowork.dataAccess.concretes;

import java.util.Date;

public class EmployeeDto {
	
	private long id;
	private String first_name;
	private String last_name;
	private DepartmentDto department;
	private double salary;
	private Date joining_date;
	private GraduationDto graduation;
	private Date leaving_date;
	
	public GraduationDto getGraduation() {
		return graduation;
	}
	public void setGraduation(GraduationDto graduation) {
		this.graduation = graduation;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public DepartmentDto getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentDto department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getFirstName() {
		return first_name;
	}
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	public String getLastName() {
		return last_name;
	}
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	public Date getJoiningDate() {
		return joining_date;
	}
	public void setJoiningDate(Date joining_date) {
		this.joining_date = joining_date;
	}
	public Date getLeavingDate() {
		return leaving_date;
	}
	public void setLeavingDate(Date leaving_date) {
		this.leaving_date = leaving_date;
	}
	
	
	

	
	
}
