package com.amer.spring.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class product {
	
	//idproduct, product_name, product_image, product_price
	@Id
	private int idproduct ;
	private String product_name ;
	private String product_image ;
	private int product_price ;

}
