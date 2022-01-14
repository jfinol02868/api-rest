package com.finol.app.desarrollo.rest.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.finol.app.desarrollo.rest.entity.UserEntity;
import com.finol.app.desarrollo.rest.repository.UserRepository;
import com.finol.app.desarrollo.rest.services.UserService;
import com.finol.app.desarrollo.rest.shared.dto.UserDto;
import com.finol.app.desarrollo.rest.util.Util;

/*
 *  Creado por: Jesus E. Finol
 */

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private Util util;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto createUser(UserDto userDto) {		
		
		UserEntity validateEmail = userRepository.findByEmail(userDto.getEmail());
		
		if(validateEmail != null) throw new RuntimeException("Email ya se encuentra registrado.");
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		userEntity.setUserId(util.getRadomPublicId());
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		UserEntity userSaved = userRepository.save(userEntity);
		
		UserDto userDtoResponse = new UserDto();
		BeanUtils.copyProperties(userSaved, userDtoResponse);
		
		return userDtoResponse;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}	
}
