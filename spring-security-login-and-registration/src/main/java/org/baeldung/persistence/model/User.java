package org.baeldung.persistence.model;

import java.sql.Date;

import javax.persistence.CascadeType;
//ERASE

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "firstName", columnDefinition = "varchar(120) COLLATE utf8_bin")
    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private boolean enabled;

    private boolean tokenExpired;
    @Column(name = "phone", columnDefinition = "varchar(120) COLLATE utf8_bin")
    private String phone;
    
    private Double xu;
    
    private Double ruttien;
    
    private int status;
   
    
    @Column(name = "fullname", columnDefinition = "varchar(120) COLLATE utf8_bin")
    private String fullname;
    
    private Date expiryDate;
    
    private Double tiendachuyen;
    
    private int statusdachuyen;
    
    private int loginstatus;

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


	public Double getXu() {
		return xu;
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


	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}

	@OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Role role;

    public User() {
        super();
        this.enabled = false;
        this.tokenExpired = false;
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

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(boolean expired) {
        this.tokenExpired = expired;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final User user = (User) obj;
        if (!email.equals(user.email))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [firstName=").append(firstName).append("]").append("[lastName=").append(lastName).append("]").append("[username").append(email).append("]");
        return builder.toString();
    }

	

}