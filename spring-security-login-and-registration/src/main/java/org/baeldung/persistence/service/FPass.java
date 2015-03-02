package org.baeldung.persistence.service;

import javax.validation.constraints.NotNull;


import javax.validation.constraints.Size;

import org.baeldung.validation.service.ValidEmail;
import org.hibernate.validator.constraints.NotEmpty;


public class FPass {
	
	
	@ValidEmail
	@NotNull
	 @Size(min = 1, max = 50, message = "Email không được để trống")
    private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

   
}
