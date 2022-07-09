package com.amer.spring.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amer.spring.ecommerce.dao.authorityRepository;
import com.amer.spring.ecommerce.entity.authority;

@Service
public class authorityServiceImpl implements authorityService {

	@Autowired
	private authorityRepository repo ;
	
	@Override
	public void save(authority aut) {
		// TODO Auto-generated method stub
        repo.save(aut);
	}

}
