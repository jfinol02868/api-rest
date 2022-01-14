package com.finol.app.desarrollo.rest.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.finol.app.desarrollo.rest.services.UserService;

@EnableWebSecurity
public class WebSecutiry extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder  bCryptPasswordEncoder;
	@Autowired
	private UserService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/users")
		.permitAll()
		.anyRequest()
		.authenticated();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}	
}
