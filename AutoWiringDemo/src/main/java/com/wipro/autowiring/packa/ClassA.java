package com.wipro.autowiring.packa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.autowiring.packc.ClassB;


@RestController
public class ClassA {

	@Autowired
	ClassB b ;
	
	
	@GetMapping
	public String methodA() {
		b.methodB();
		return "hello";
	}
	
}
