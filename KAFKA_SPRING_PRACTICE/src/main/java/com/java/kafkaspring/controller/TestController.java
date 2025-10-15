package com.java.kafkaspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.kafkaspring.service.ServiceInterface;

@RestController
public class TestController {

	@Autowired
	@Qualifier("service1")
	ServiceInterface ser;
	
	@GetMapping
	public String getMessage() {
		return "working";
	}
	
}
