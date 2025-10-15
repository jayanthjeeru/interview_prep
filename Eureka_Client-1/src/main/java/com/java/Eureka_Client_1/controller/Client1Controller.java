package com.java.Eureka_Client_1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Client1Controller {
	
	
	@GetMapping("/getmessage")
	public String getMessage() {
		return "this is client-1";
	}

}
