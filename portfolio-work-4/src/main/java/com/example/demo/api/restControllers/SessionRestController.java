package com.example.demo.api.restControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="sessions")
public class SessionRestController {

	@PostMapping()
	public ResponseEntity<String> getResponse(){
		return ResponseEntity.status(HttpStatus.OK).body("a");
	}
}
