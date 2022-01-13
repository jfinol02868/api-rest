package com.finol.app.desarrollo.rest.shared.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *  Creado por: Jesus E. Finol
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

	/**
	 * 	Serial de la clase
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String encryptedPassword;
	private String emailVerificationToken;
	private Boolean emailVerificationStatus = false;
	private List<AddressDto> address;
	
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
