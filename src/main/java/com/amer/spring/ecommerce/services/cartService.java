package com.amer.spring.ecommerce.services;

import java.util.List;

import com.amer.spring.ecommerce.entity.cart;


public interface cartService {

	public void save (cart c ,int pid , String username);
	
	public List<cart> find();
	
	
	void decrese(int pid , String username) ;
}
