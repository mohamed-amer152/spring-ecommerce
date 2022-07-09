package com.amer.spring.ecommerce.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.amer.spring.ecommerce.services.authHelper;

@Component
public class authHelperImpl implements authHelper {

	@Override
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	@Override
	public String getName() {
        return getAuthentication().getName();
	}

	@Override
	public UserDetails getUserDetails() {
        return (UserDetails) getAuthentication().getPrincipal();
	}

}
