package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.service.DemoService;

import jakarta.websocket.server.PathParam;

@RestController
public class DemoController {
	
	@Autowired
	DemoService service;
	
	@GetMapping("get/{msg}")
	public String getMessage(@PathParam("msg") String msg) {
		service.sendMessage(msg);
		return "hi";
	}

}
