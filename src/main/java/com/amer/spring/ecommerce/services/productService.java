package com.amer.spring.ecommerce.services;

import java.util.List;

import com.amer.spring.ecommerce.entity.product;

public interface productService {
	
	public void save(product p);
	
	public List<product> productList() ;
	
	public void delete(int id );
	
	

}
