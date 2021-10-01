package com.kemalyanmaz.portfoliowork.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="department_summary",length=1000)
	private String departmentSummary;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	
}
