package com.kemalyanmaz.portfoliowork.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalyanmaz.portfoliowork.business.abstracts.GraduationService;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.GraduationDto;

@RestController
@RequestMapping(path="api/graduations")
public class GraduationRestController {

	private GraduationService graduationService;
	
	@Autowired
	public GraduationRestController(GraduationService graduationService) {
		this.graduationService = graduationService;
	}
	
	@GetMapping()
	public List<GraduationDto> getAllGraduations(){
		return graduationService.getAll();
	}
}
