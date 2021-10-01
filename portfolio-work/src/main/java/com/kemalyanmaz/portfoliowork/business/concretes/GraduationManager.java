package com.kemalyanmaz.portfoliowork.business.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalyanmaz.portfoliowork.business.abstracts.GraduationService;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.GraduationDao;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.GraduationDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Graduation;

@Service
public class GraduationManager implements GraduationService	{

	private GraduationDao graduationDao;
	
	@Autowired
	public GraduationManager(GraduationDao graduationDao) {
		this.graduationDao = graduationDao;
	}

	@Override
	public List<GraduationDto> getAll() {
		Map<Long,GraduationDto> graduationDtoMap = new HashMap<>();
		graduationDao.findAll().forEach(graduation->{
			graduationDtoMap.put(graduation.getId(), graduationToDto(graduation));
		});
		List<GraduationDto> graduationDtoList = new ArrayList<>();
		for(long id:graduationDtoMap.keySet()) {
			graduationDtoList.add(graduationDtoMap.get(id));
		}
		
		return graduationDtoList;
	
	}
	
	private GraduationDto graduationToDto(Graduation graduation) {
		GraduationDto graduationDto = new GraduationDto();
		graduationDto.setGraduationName(graduation.getGraduationName());
		return graduationDto;
	}

	@Override
	public GraduationDto getById(long id) {
		return graduationToDto(graduationDao.findById(id).orElse(new Graduation()));
	}
	
	
}
