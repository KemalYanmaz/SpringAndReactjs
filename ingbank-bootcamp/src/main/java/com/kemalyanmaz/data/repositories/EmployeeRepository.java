package com.kemalyanmaz.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemalyanmaz.data.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
