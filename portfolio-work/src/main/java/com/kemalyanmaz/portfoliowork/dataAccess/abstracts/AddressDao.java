package com.kemalyanmaz.portfoliowork.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kemalyanmaz.portfoliowork.entities.concretes.Address;

public interface AddressDao extends JpaRepository<Address,Long>{

}
