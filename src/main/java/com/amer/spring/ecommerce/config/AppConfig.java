package com.amer.spring.ecommerce.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {
		
	@Autowired
	@Qualifier("securitydatasource")
	private DataSource securitydatasource ;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
              auth.jdbcAuthentication().dataSource(securitydatasource);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {  // ADMIN   CUSTOMER 'ROLE_CUSTOMER'
		http
		.authorizeRequests()
		.antMatchers("/getProducts").hasAnyRole("CUSTOMER","ADMIN")
		.antMatchers("/toupdate").hasAnyRole("ADMIN")
		.antMatchers("/resources/**").permitAll()
		.and()
				.formLogin()
				.loginPage("/showlogin")
				.loginProcessingUrl("/auth")
				.permitAll()
		.and()
				.logout()
				.permitAll()
		.and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied");		
	;
	}
	
	
}
