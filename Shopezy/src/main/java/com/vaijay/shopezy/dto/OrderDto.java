package com.vaijay.shopezy.dto;

import java.util.List;

import com.vaijay.shopezy.entity.Product;

public class OrderDto {
	
	int id;
	int custid;
	List<Product> products;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public OrderDto(int id, int custid, List<Product> products) {
		super();
		this.id = id;
		this.custid = custid;
		this.products = products;
	}
	
	
	

}
