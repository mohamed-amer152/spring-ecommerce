package com.amer.spring.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amer.spring.ecommerce.dao.contactRepository;
import com.amer.spring.ecommerce.entity.contact;
@Service
public class contactServiceImpl implements contactService {

	
	@Autowired
	private contactRepository repo ;
	
	@Override
	public List<contact> find() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void save(contact c) {
		// TODO Auto-generated method stub
        repo.save(c);
	}

}
