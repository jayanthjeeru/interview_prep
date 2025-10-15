package com.vaijay.shopezy.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaijay.shopezy.dto.OrderDto;
import com.vaijay.shopezy.entity.Customer;
import com.vaijay.shopezy.entity.Order;
import com.vaijay.shopezy.entity.Product;
import com.vaijay.shopezy.repository.CustomerRepo;
import com.vaijay.shopezy.repository.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Override
	public Order getOrderById(int id) {

		Optional<Order> o = orderRepo.findById(id);
		
		if(o.isPresent())
			return o.get();
		else
			return null;
	}

	@Override
	public Order persistOrder(OrderDto order) {

//		Optional<Customer> customer = customerRepo.findById(custid);
//		
//		Order o = new Order();
//		o.setId(id);
//		if(customer.isPresent())
//			o.setCustomer(customer.get());
//		else
//			o.setCustomer(null);
//		
//		o.setProducts(products);
		
		
		
		int totalPrice=0;
		for(Product s : order.getProducts()) {
			totalPrice += s.getPrice()*s.getQuantity();
		}
		
		Order o = new Order();
		o.setProducts(order.getProducts());
		o.setId(order.getId());
		Optional<Customer> cus = customerRepo.findById(order.getCustid());
		if(cus.isPresent())
			o.setCustomer(cus.get());
		else
			o.setCustomer(null);
		o.setTotalPrice(totalPrice);
		return orderRepo.save(o);
		
		

	}

}
