package com.kemalyanmaz.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemalyanmaz.data.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
