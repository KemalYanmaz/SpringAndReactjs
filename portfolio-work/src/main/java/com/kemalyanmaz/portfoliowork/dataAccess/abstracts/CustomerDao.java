package com.kemalyanmaz.portfoliowork.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kemalyanmaz.portfoliowork.entities.concretes.Customer;

public interface CustomerDao extends JpaRepository<Customer,Long>{

}
