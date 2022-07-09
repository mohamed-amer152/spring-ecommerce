package com.amer.spring.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="cart" )

public class cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String username ;
	private String productname ;
	private int productquantity =0 ;
	private int productprice ;
	private int producttotal ;
	private String cartstatus ="intialized" ;
	private String productimg ;

}
