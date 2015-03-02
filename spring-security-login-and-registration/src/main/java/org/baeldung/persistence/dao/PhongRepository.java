package org.baeldung.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.baeldung.persistence.model.Phong;


public interface PhongRepository extends JpaRepository<Phong, Long> {
    public Phong findByMaBan(int maBan);
    public void delete(Phong phong);

}
