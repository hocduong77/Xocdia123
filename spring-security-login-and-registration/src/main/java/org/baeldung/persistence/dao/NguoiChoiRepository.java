package org.baeldung.persistence.dao;

import org.baeldung.persistence.model.NguoiChoi;
import org.springframework.data.jpa.repository.JpaRepository;

	public interface NguoiChoiRepository extends JpaRepository<NguoiChoi, Long> {
	    public NguoiChoi findByMaBan(int maBan);
	    public NguoiChoi findByEmail(String email);
	    public void delete(NguoiChoi nguoiChoi);

	}

