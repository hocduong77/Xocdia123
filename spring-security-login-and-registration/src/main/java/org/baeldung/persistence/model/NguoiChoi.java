package org.baeldung.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NguoiChoi {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	 
	 	private int maBan;
	 	
	 	private String email;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public int getMaBan() {
			return maBan;
		}

		public void setMaBan(int maBan) {
			this.maBan = maBan;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		
}
