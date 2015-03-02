package org.baeldung.persistence.dao;

import org.baeldung.persistence.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;


	public interface AdminRepository extends JpaRepository<Admin, Long> {

		 public Admin findById(int id);
				 
	}

