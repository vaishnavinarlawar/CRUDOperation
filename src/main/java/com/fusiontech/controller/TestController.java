package com.fusiontech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/getName")
	public String getName() {
		System.out.println("inside TestController.getName-9097");
		return "hello Developer from 9097";
	}

}
