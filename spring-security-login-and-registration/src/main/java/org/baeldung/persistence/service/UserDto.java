package org.baeldung.persistence.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.baeldung.validation.service.PasswordMatches;
import org.baeldung.validation.service.ValidEmail;
import org.hibernate.validator.constraints.NotEmpty;

@PasswordMatches
public class UserDto {
    @NotNull   
    @Size(min = 1, max = 50, message = "Vui lòng nhập nickname")
    private String firstName;

    
    private String lastName;

    @NotNull  
    @Size(min = 1, max = 30, message = "Mật khẩu không được để trống")
    private String password;

    @NotNull   
    @Size(min = 1, max = 30, message = "Vui lòng nhập lại mật khẩu")
    private String matchingPassword;

    @ValidEmail
    @NotNull   
    @Size(min = 1, max = 50, message = "Email không được để trống")
    private String email;
    
    private String fullname;
   
    private String phone;

    private Double xu;
    private Double xunap;
    private boolean accept; 
    
    private Double ruttien;
    
    private int status;
    private Double tiendachuyen;
    
    private int statusdachuyen;
    
    private int loginstatus;
    
    private Long id;
    
    
    /*
     * @Size(min = 1, max = 50, message = "Vui lòng nhập nickname")
    private String firstName;

    
    private String lastName;

    @Size(min = 1, max = 30, message = "Mật khẩu không được để trống")
    private String password;

    @Size(min = 1, max = 30, message = "Vui lòng nhập lại mật khẩu")
    private String matchingPassword;

    @ValidEmail
    @Size(min = 1, max = 50, message = "Email không được để trống")
    private String email;
*/    
   

	public Double getXu() {
		return xu;
	}

	public Double getXunap() {
		return xunap;
	}

	public void setXunap(Double xunap) {
		this.xunap = xunap;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getLoginstatus() {
		return loginstatus;
	}

	public void setLoginstatus(int loginstatus) {
		this.loginstatus = loginstatus;
	}

	public Double getTiendachuyen() {
		return tiendachuyen;
	}

	public void setTiendachuyen(Double tiendachuyen) {
		this.tiendachuyen = tiendachuyen;
	}

	public int getStatusdachuyen() {
		return statusdachuyen;
	}

	public void setStatusdachuyen(int statusdachuyen) {
		this.statusdachuyen = statusdachuyen;
	}

	public void setXu(Double xu) {
		this.xu = xu;
	}

	public Double getRuttien() {
		return ruttien;
	}

	public void setRuttien(Double ruttien) {
		this.ruttien = ruttien;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private Integer role;

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [firstName=").append(firstName).append("]").append("[lastName=").append(lastName).append("]").append("[email").append(email).append("]").append("[password").append(password).append("]");
        return builder.toString();
    }
}
