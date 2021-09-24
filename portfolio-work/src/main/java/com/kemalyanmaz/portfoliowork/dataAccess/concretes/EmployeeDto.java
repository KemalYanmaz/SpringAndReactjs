package com.kemalyanmaz.portfoliowork.dataAccess.concretes;

public class EmployeeDto {
	
	private long id;
	private String firstName;
	private String lastName;
	private long departmentId;
	private String departmentName;
	private String departmentSummary;
	private double salary;
	private long graduationId;
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
	public long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
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
	public long getGraduationId() {
		return graduationId;
	}
	public void setGraduationId(long graduationId) {
		this.graduationId = graduationId;
	}
	public String getGraduationName() {
		return graduationName;
	}
	public void setGraduationName(String graduationName) {
		this.graduationName = graduationName;
	}
	
	
	

	
	
}
