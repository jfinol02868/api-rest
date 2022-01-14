package com.finol.app.desarrollo.rest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *  Creado por: Jesus E. Finol
 */
@Data
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity  implements Serializable {

	/**
	 *  Serial de la clase 'UserEntity'
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id", nullable = false)
	private String userId;
	
	@Column(name = "first_name", nullable = false, length =50)
	private String firstName;
	
	@Column(name = "last_name", nullable = false,  length =50)
	private String lastName;
	
	@Column(name = "email", unique = true, nullable = false, length = 120)
	private String email;
	
	@Column(name = "encrypted_password", nullable = false)
	private String encryptedPassword;
	
	@Column(name = "email_verification_token")
	private String emailVerificationToken;
	
	@Column(name = "email_verification_status", nullable = false)
	private Boolean emailVerificationStatus = false;
	
	public String toJsson() {
		ObjectMapper o = new ObjectMapper();
		String jSon;
		try {
			jSon = o.writerWithDefaultPrettyPrinter().writeValueAsString(this);
			return jSon;
		} catch (Exception e) {
			return this.toString();
		}
	}
}
