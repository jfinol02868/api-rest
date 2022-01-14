package com.finol.app.desarrollo.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.finol.app.desarrollo.rest.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	public UserEntity findByEmail(String email);

}
