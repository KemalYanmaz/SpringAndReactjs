package com.kemalyanmaz.portfoliowork.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.kemalyanmaz.portfoliowork.data.StaffRepository;
import com.kemalyanmaz.portfoliowork.models.Position;
import com.kemalyanmaz.portfoliowork.models.StaffMember;

@Service
public class StaffService {

    private final StaffRepository staffRepository;
    
    public StaffService(StaffRepository staffRepository){
    	this.staffRepository = staffRepository;
    }


    public List<StaffMember> getAllStaff(){
        return staffRepository.findAll();
    }
}