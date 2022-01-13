package com.finol.app.desarrollo.rest.models.response;

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
public class UserRest implements Serializable {
	/**
	 *  Serial de la clase
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	
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
