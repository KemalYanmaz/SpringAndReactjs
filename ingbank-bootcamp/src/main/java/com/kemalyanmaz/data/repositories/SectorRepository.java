package com.kemalyanmaz.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemalyanmaz.data.entities.Sector;


@Repository
public interface SectorRepository extends JpaRepository<Sector,Long>{

}
