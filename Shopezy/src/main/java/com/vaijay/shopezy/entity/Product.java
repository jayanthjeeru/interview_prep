package com.vaijay.shopezy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products") 
public class Product {

	@Id
	int id;
	String proName;
	int price;
	int quantity;
	
	
	

	public Product(int id, String proName, int price, int quantity) {
		
		this.id = id;
		this.proName = proName;
		this.price = price;
		this.quantity = quantity;
	}




	@Override
	public String toString() {
		return "Product [id=" + id + ", proName=" + proName + ", price=" + price + ", quantity=" + quantity + "]";
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getProName() {
		return proName;
	}




	public void setProName(String proName) {
		this.proName = proName;
	}




	public int getPrice() {
		return price;
	}




	public void setPrice(int price) {
		this.price = price;
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public Product() {
		
	}
	
	
	
	
	
}
