package com.example.alpha.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.alpha.pojo.AppResponseMessage;

@RestController
public class AppIntroController {

	@GetMapping("/")
	public AppResponseMessage introApp() {
		return new AppResponseMessage(HttpStatus.OK.value(), "Welcome to Transport app tracking vehicles.", null);
	}
	
	@GetMapping("/versions")
	public AppResponseMessage softwareDetailsVersion() {
		return new AppResponseMessage(HttpStatus.OK.value(), "TradeMarck : 577414, Software version : 0.0.0.1 date = 20-05-2025", null);
	}
	
	
}
