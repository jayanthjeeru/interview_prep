package com.vaijay.shopezy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	int id;
	String country;
	String state;
	String district;
	int pincode;
	String landMark;
	String doorNumber;

//	@OneToOne(mappedBy = "address")
//	Customer customer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public Customer getCustomer() {
//		return customer;
//	}
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public String getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}
	@Override
	public String toString() {
		return "Address [country=" + country + ", state=" + state + ", district=" + district + ", pincode=" + pincode
				+ ", landMark=" + landMark + ", doorNumber=" + doorNumber + "]";
	}
	
	
	public Address(int id, String country, String state, String district, int pincode, String landMark,
			String doorNumber) {

		this.id = id;
		this.country = country;
		this.state = state;
		this.district = district;
		this.pincode = pincode;
		this.landMark = landMark;
		this.doorNumber = doorNumber;
//		this.customer = customer;
	}
	
	public Address() {
		
	}
	
	
}
