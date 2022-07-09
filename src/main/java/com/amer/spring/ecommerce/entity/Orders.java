package com.amer.spring.ecommerce.entity;

import java.util.Date;
import java.util.Random;

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
@Table(name = "ordertable")
public class Orders {

	// id, username, orderdate, customeraddress, customerphone, ordertotal,
	// orderstatus, ordernumber
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String orderdate = new Date().toString();
	private String customeraddress;
	private String customerphone;
	private int ordertotal;
	private String orderstatus = "placed";
	private String ordernumber =""+ new Random().nextInt(1000000);

}
