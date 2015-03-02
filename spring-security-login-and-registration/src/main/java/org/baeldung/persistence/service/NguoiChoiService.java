package org.baeldung.persistence.service;

import java.util.List;

import javax.transaction.Transactional;

import org.baeldung.persistence.dao.NguoiChoiRepository;
import org.baeldung.persistence.dao.PhongRepository;
import org.baeldung.persistence.dao.UserRepository;
import org.baeldung.persistence.model.NguoiChoi;
import org.baeldung.persistence.model.Phong;
import org.baeldung.validation.service.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class NguoiChoiService {

	 	@Autowired
	    private UserRepository repository;

	    @Autowired
	    private NguoiChoiRepository nguoiChoiRepository;
	    
	    
	    @Autowired
	    private PhongRepository phongRepository;
	    
	    
	    
	    public NguoiChoi createNewPhong(NguoiChoiDto nguoiChoidto) throws EmailExistsException {
	    	NguoiChoi nguoichoi = new NguoiChoi();
	      
	      nguoichoi.setMaBan(nguoiChoidto.getMaBan());
	      nguoichoi.setEmail(nguoiChoidto.getNguoiChoi());
	       
	        return nguoiChoiRepository.save(nguoichoi);
	    }
	    
	    public NguoiChoi findnguoichoi(String email){	    	
	    	return nguoiChoiRepository.findByEmail(email);
	    }
	    
	    public NguoiChoi findnguoichoiByMB(int maBan){
	    	
	    	return nguoiChoiRepository.findByMaBan(maBan);
	    }
	    
	    public void deleteNguoiChoi(NguoiChoi nguoichoi){
	    	nguoiChoiRepository.delete(nguoichoi);
	    }
	    public List<NguoiChoi> getAllNguoiChoi() {
	        List<NguoiChoi> allPhong= nguoiChoiRepository.findAll();
	        return allPhong;
	    }
	    
	    
}
