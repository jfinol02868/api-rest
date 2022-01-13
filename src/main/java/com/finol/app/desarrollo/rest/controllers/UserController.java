package com.finol.app.desarrollo.rest.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finol.app.desarrollo.rest.models.request.UserDetailRequestModel;
import com.finol.app.desarrollo.rest.models.response.UserRest;
import com.finol.app.desarrollo.rest.services.UserService;
import com.finol.app.desarrollo.rest.shared.dto.UserDto;

/*
 *  Creado por: Jesus E. Finol
 */

@RestController
@RequestMapping("/users") // https://web-api-services.herokuapp.com/users
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String  getUsers() {
		return "get users was called";
	}
	
	@PostMapping
	public UserRest  createUsers(@RequestBody UserDetailRequestModel userDetail) {
		
		System.out.println(userDetail.toJsson());
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetail, userDto);
		userDto = userService.createUser(userDto);
		
		UserRest returnValue = new UserRest();
		BeanUtils.copyProperties(userDto, returnValue);
		
		return returnValue;
	}
	
	@PutMapping
	public String  updateUsers() {
		return "update users was called";
	}
	
	@DeleteMapping
	public String  deleteUsers() {
		return "delete users was called";
	}	
}
