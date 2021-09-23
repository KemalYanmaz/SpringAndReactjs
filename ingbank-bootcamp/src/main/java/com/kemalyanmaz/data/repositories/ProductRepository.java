package com.kemalyanmaz.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemalyanmaz.data.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

}
