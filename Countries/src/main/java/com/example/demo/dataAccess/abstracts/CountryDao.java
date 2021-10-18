package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entities.concretes.Country;

public interface CountryDao extends JpaRepository<Country,Long>,JpaSpecificationExecutor<Country>{

	List<Country> findByCapitalStartingWithIgnoreCase(String capital);
	
	List<Country> findAll();
}
