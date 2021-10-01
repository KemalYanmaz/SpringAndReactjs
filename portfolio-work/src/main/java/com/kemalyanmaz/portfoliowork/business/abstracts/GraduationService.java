package com.kemalyanmaz.portfoliowork.business.abstracts;

import java.util.List;

import com.kemalyanmaz.portfoliowork.dataAccess.concretes.GraduationDto;

public interface GraduationService {
	List<GraduationDto> getAll();
	
	GraduationDto getById(long id);
}
