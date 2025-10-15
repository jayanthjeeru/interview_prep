package com.java.kafkaspring.service;

import org.springframework.stereotype.Service;

@Service("service1")
public class Service1 implements ServiceInterface {

	@Override
	public String message() {
		
		return "hi SERVICE1";
	}

}
