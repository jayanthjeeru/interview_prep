package com.vaijay.shopezy.service;

import org.springframework.stereotype.Service;

import com.vaijay.shopezy.entity.Customer;

@Service
public interface CustomerService {

	public Customer persistCustomer(Customer customer);
	
	public Customer getCustomerById(int id);
	
}
