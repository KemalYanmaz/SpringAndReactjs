package com.kemalyanmaz.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemalyanmaz.data.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{

}
