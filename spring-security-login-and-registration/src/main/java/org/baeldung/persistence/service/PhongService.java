package org.baeldung.persistence.service;
import java.util.List;

import org.baeldung.persistence.dao.PhongRepository;
import org.baeldung.persistence.dao.UserRepository;
import org.baeldung.persistence.dao.VerificationTokenRepository;
import org.baeldung.persistence.model.Phong;
import org.baeldung.validation.service.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PhongService  {
    @Autowired
    private UserRepository repository;

    @Autowired
    private VerificationTokenRepository tokenRepository;
    
    
    @Autowired
    private PhongRepository phongRepository;
    
    
    
    public Phong createNewPhong(PhongDto phongdto) throws EmailExistsException {
       Phong phong = new Phong();
      
       phong.setMaBan(phongdto.getMaBan());
       phong.setSoNguoi(phongdto.getSoNguoi());
       phong.setXuToiThieu(phongdto.getXuToiThieu());
       phong.setLoaiBan(phongdto.getLoaiBan());
       phong.setSoChoi(phongdto.getSoChoi());
       
        return phongRepository.save(phong);
    }
    
    public List<Phong> getAllPhong() {
        List<Phong> allPhong= phongRepository.findAll();
        return allPhong;
    }
    public Phong getPhong(int maban) {
		return phongRepository.findByMaBan(maban);
	}
    public void savePhong(Phong phong) {
        phongRepository.save(phong);
    }
    
    public void deletePhong(Phong phong) {
        phongRepository.delete(phong);
    }
    
}
