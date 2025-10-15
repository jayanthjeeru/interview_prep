package com.vaijay.shopezy.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	int id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "custId")
	Customer customer;

	@OneToMany(targetEntity = Product.class , cascade = CascadeType.ALL)
    @JoinColumn(name = "op_fid", referencedColumnName = "id")
	List<Product> products;
	
	int totalPrice;
	
	

	

	public Order(int id, Customer customer, List<Product> products, int totalPrice) {
		
		this.id = id;
		this.customer = customer;
		this.products = products;
		this.totalPrice = totalPrice;
	}





	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", products=" + products + ", totalPrice=" + totalPrice
				+ "]";
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public Customer getCustomer() {
		return customer;
	}





	public void setCustomer(Customer customer) {
		this.customer = customer;
	}





	public List<Product> getProducts() {
		return products;
	}





	public void setProducts(List<Product> products) {
		this.products = products;
	}





	public int getTotalPrice() {
		return totalPrice;
	}





	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}





	public Order() {
		
	}
	
}
