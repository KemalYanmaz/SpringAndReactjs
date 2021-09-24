package com.kemalyanmaz.portfoliowork.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kemalyanmaz.portfoliowork.entities.concretes.Offer;

public interface OfferDao extends JpaRepository<Offer,Long>{

}
