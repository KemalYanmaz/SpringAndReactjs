package com.example.demo.api.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.RecordService;
import com.example.demo.core.ResponseMessage;
import com.example.demo.dataAccess.dto.RecordDto;

@RestController
@RequestMapping(path="/records")
public class RecordRestController {

	private RecordService recordService;
	
	@Autowired
	public RecordRestController(RecordService recordService) {
		this.recordService = recordService;
	}
	
	@PatchMapping(path="/{id}")
	public ResponseMessage<?> patchRecord(@PathVariable("id") long id) {
		return recordService.patchRecord(id);
	}
}
