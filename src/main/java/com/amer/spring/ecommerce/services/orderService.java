package com.amer.spring.ecommerce.services;

import java.util.List;

import com.amer.spring.ecommerce.entity.Orders;

public interface orderService {

	public void save (Orders o , String username) ;
	
	public List<Orders> getorders() ;
}
