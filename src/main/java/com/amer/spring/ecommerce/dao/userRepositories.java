package com.amer.spring.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amer.spring.ecommerce.entity.user;

public interface userRepositories extends JpaRepository<user, String> {
	
	user findByUsername (String name) ;

}
