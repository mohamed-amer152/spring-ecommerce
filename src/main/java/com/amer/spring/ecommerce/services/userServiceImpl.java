package com.amer.spring.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amer.spring.ecommerce.dao.userRepositories;
import com.amer.spring.ecommerce.entity.user;

@Service
public class userServiceImpl implements userService {

	@Autowired
	private userRepositories repo ;
	
	@Override
	public void save(user u) {
		repo.save(u);

	}

	@Override
	public user search(String name) {
		user u = repo.findByUsername(name);
		return u;
	}

}
