package org.baeldung.persistence.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.baeldung.validation.service.PasswordMatches;


@PasswordMatches
public class ForgetP {
	@NotNull
	 @Size(min = 1, max = 50, message = "Mật khẩu không được để trống")
    private String pass;
	
	@NotNull
	 @Size(min = 1, max = 50, message = "Vui lòng nhập lại mật khẩu")
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
