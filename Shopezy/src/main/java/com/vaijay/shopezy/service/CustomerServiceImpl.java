package com.vaijay.shopezy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaijay.shopezy.entity.Customer;
import com.vaijay.shopezy.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Override
	public Customer persistCustomer(Customer customer) {

		return customerRepo.save(customer);
	}

	@Override
	public Customer getCustomerById(int id) {

		Optional<Customer> c = customerRepo.findById(id);
		if(c.isPresent())
			return c.get();
		else
			return null;
	}


	
}
