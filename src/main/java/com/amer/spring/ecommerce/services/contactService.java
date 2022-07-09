package com.amer.spring.ecommerce.services;

import java.util.List;

import com.amer.spring.ecommerce.entity.contact;

public interface contactService {
	
	List<contact> find();
	
	void save(contact c);

}
