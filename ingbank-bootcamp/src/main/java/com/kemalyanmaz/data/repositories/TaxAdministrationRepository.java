package com.kemalyanmaz.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemalyanmaz.data.entities.TaxAdministration;

@Repository
public interface TaxAdministrationRepository extends JpaRepository<TaxAdministration,Long>{

}
