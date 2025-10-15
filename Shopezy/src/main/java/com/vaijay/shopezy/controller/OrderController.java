package com.vaijay.shopezy.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaijay.shopezy.dto.OrderDto;
import com.vaijay.shopezy.entity.Order;
import com.vaijay.shopezy.entity.Product;
import com.vaijay.shopezy.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("order/{id}")
	public Order getOrderById(@PathVariable int id) {
		
		return orderService.getOrderById(id);
	}
	
	@PostMapping("order")
	public Order persistOrder( @RequestBody OrderDto order) {
		
		return orderService.persistOrder(order);
		
	}
	
}
