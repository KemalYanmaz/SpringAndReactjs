package com.kemalyanmaz.portfoliowork.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kemalyanmaz.portfoliowork.entities.concretes.Graduation;

public interface GraduationDao extends JpaRepository<Graduation,Long>{

}
