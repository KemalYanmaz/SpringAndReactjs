package com.kemalyanmaz.portfoliowork.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kemalyanmaz.portfoliowork.models.StaffMember;

public interface StaffRepository extends JpaRepository<StaffMember,String>{

}
