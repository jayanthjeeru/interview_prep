package com.vaijay.shopezy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaijay.shopezy.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}
