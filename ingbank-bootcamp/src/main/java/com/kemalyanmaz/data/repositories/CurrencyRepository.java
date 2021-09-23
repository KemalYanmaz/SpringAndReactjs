package com.kemalyanmaz.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemalyanmaz.data.entities.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

}
