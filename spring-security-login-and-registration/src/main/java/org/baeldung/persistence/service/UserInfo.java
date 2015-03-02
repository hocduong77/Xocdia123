package org.baeldung.persistence.service;

import org.baeldung.validation.service.ValidEmail;

public class UserInfo {
	private String firstName;
	private String fullname;
	private String phone;
	@ValidEmail
	private String email;
	private String lastName;
	private long id ;
	private int ruttien ;
	
	public int getRuttien() {
		return ruttien;
	}
	public void setRuttien(int ruttien) {
		this.ruttien = ruttien;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	
}
