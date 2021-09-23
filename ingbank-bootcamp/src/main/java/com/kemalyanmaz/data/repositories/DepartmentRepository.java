package com.kemalyanmaz.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemalyanmaz.data.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{

}
