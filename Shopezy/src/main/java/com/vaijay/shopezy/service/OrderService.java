package com.vaijay.shopezy.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.vaijay.shopezy.dto.OrderDto;
import com.vaijay.shopezy.entity.Order;
import com.vaijay.shopezy.entity.Product;

@Service
public interface OrderService {

	public Order getOrderById(int id);
	
	public Order persistOrder(OrderDto order);
	
}
