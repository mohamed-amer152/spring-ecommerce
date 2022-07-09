package com.amer.spring.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.amer.spring.ecommerce.entity.product;

public interface productRepository extends JpaRepository<product, Integer> {

	//idproduct, product_name, product_image, product_price
	
	// selecting product by name 
	@Query("select idproduct from product p where p.product_name = :pn")
	public int getproductid(@Param("pn") String pn );
}
