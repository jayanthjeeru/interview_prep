package com.vaijay.shopezy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaijay.shopezy.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
