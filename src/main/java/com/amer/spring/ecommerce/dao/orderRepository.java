package com.amer.spring.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amer.spring.ecommerce.entity.Orders;

public interface orderRepository extends JpaRepository<Orders, Integer> {

}
