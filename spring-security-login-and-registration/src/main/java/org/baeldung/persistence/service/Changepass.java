package org.baeldung.persistence.service;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;




public class Changepass {	
	@NotNull
    @NotEmpty
    private String pass;
	
	@NotNull
    @NotEmpty
    private String repass;

	

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRepass() {
		return repass;
	}

	public void setRepass(String repass) {
		this.repass = repass;
	}
}
