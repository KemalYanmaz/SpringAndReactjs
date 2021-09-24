package com.kemalyanmaz.portfoliowork.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kemalyanmaz.portfoliowork.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Long>{
	
}
