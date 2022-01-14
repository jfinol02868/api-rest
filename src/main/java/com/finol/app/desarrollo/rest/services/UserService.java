package com.finol.app.desarrollo.rest.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.finol.app.desarrollo.rest.shared.dto.UserDto;

public interface UserService extends UserDetailsService {
	
	public UserDto createUser(UserDto userDto);

}
