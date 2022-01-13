package com.finol.app.desarrollo.rest.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finol.app.desarrollo.rest.entity.UserEntity;
import com.finol.app.desarrollo.rest.repository.UserRepository;
import com.finol.app.desarrollo.rest.services.UserService;
import com.finol.app.desarrollo.rest.shared.dto.UserDto;

/*
 *  Creado por: Jesus E. Finol
 */

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		userEntity.setUserId("df2d1f6sd4f5sd");
		userEntity.setEncryptedPassword("123456789");
		UserEntity userSaved = userRepository.save(userEntity);
		
		UserDto userDtoResponse = new UserDto();
		BeanUtils.copyProperties(userSaved, userDtoResponse);
		
		return userDtoResponse;
	}
	
}
