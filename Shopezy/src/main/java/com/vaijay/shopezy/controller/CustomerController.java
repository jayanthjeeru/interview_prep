package com.vaijay.shopezy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaijay.shopezy.entity.Customer;
import com.vaijay.shopezy.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private Environment env;

	@Autowired
	CustomerService customerService;
	
	
	@PostMapping()
	public Customer persistCustomer(@RequestBody Customer customer) {
		
		return customerService.persistCustomer(customer);
		
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		System.out.println("lala ::"+env.getProperty("thread.count"));
		return customerService.getCustomerById(id);
		
	}
	
}
