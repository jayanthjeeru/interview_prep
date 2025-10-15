package com.java.kafkaspring.service;

import org.springframework.stereotype.Service;

@Service("service2")
public class Service2 implements ServiceInterface {

	@Override
	public String message() {
	
		return "hi SERVICE2";
	}

}
