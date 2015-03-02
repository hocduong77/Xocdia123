
package org.baeldung.persistence.dao;

import org.baeldung.persistence.model.Admin;
import org.baeldung.persistence.model.DatCuoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatCuocRepository extends JpaRepository<DatCuoc, Long> {

	 public DatCuoc findByEmail(String email);
	 
	    public void delete(DatCuoc datcuoc);
	    
	    public DatCuoc findById(Long id);
}
