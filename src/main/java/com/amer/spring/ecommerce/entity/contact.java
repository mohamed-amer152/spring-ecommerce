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
@Table(name = "contact")
public class contact {
	
	//id, username, useremail, subject, message
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ; 
	private String username ;
	private String  useremail ;
	private String subject ;
	private String message ;

}
