package com.amer.spring.ecommerce.services;

import com.amer.spring.ecommerce.entity.user;

public interface userService {

	public void save (user u );
	public user search (String name );
}
