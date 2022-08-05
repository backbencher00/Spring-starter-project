package com.animal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController {
	@GetMapping("/ping")
	public String healthCheck() {
		return "pong";
	}
	

}
