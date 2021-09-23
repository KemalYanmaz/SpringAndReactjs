package com.kemalyanmaz.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemalyanmaz.data.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long>{

}
