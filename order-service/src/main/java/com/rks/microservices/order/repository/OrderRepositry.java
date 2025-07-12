package com.rks.microservices.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rks.microservices.order.model.Order;

public interface OrderRepositry extends JpaRepository<Order, Long> {

}
