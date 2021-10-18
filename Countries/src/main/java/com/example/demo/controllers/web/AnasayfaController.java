package com.example.demo.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnasayfaController {

	
	@GetMapping("index")
	public String s() {
		return "index.html";
	}
}
