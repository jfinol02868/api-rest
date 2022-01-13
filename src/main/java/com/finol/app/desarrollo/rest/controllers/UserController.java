package com.finol.app.desarrollo.rest.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users") // https://web-api-services.herokuapp.com/users
public class UserController {
	
	@GetMapping
	public String  getUsers() {
		return "get users was called";
	}
	
	@PostMapping
	public String  createUsers() {
		return "create user";
	}
	
	@PutMapping
	public String  updateUsers() {
		return "update users";
	}
	
	@DeleteMapping
	public String  deleteUsers() {
		return "delete users";
	}	
}
