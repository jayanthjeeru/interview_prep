package com.example.messagify.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagifyController {

	
	@GetMapping("/sendmessage/{msg}/{userId}")
	public String sendMessage(@PathVariable("msg") String msg, @PathVariable("userId") String userId) {
		POPO p = new POPO();
		p.name = "hi";
		
		System.out.println(p.toString());
		return msg;
	}
	
	
}
