package com.finol.app.desarrollo.rest.models.request;

import java.io.Serializable;

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
public class UserDetailRequestModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
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
