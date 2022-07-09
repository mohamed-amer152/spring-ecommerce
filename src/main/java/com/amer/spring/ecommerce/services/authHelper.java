package com.amer.spring.ecommerce.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface authHelper {
	
	Authentication getAuthentication();
    public String getName();
    public UserDetails getUserDetails();

}
