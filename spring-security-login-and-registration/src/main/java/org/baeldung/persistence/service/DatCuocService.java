package org.baeldung.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.baeldung.persistence.dao.DatCuocRepository;
import org.baeldung.persistence.dao.PhongRepository;
import org.baeldung.persistence.dao.UserRepository;
import org.baeldung.persistence.dao.VerificationTokenRepository;
import org.baeldung.persistence.model.DatCuoc;
import org.baeldung.validation.service.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DatCuocService {

	  @Autowired
	    private UserRepository repository;
	    
	    @Autowired
	    private PhongRepository phongRepository;
	    
	    @Autowired
	    private VerificationTokenRepository tokenRepository;
	    
	    @Autowired
	    private DatCuocRepository datcuocRepository;
	    
	    public DatCuoc createNewDatCuoc(DatCuocDto datcuocDto) throws EmailExistsException {
	    	
	       DatCuoc datcuoc = new DatCuoc();
	       datcuoc.set_1den3trang((double) 0);
	       datcuoc.set_1trang3den((double) 0);
	       datcuoc.set_4den((double) 0);
	       datcuoc.setLe((double) 0);
	       datcuoc.set_4trang((double) 0);
	       datcuoc.setChan((double) 0);
	       datcuoc.setMaBan(datcuocDto.getMaBan());
	       datcuoc.setEmail(datcuocDto.getEmail());
	       datcuoc.setTongxu(datcuocDto.getTongxu());
	        return datcuocRepository.save(datcuoc);
	    }
	    
	    public DatCuoc getDatCuoc(String email) {
	    	DatCuoc datcuoc = datcuocRepository.findByEmail(email);
	        return datcuoc;
	    }
	    
	    public Boolean isDatCuoc(String email) {
	    	DatCuoc datcuoc = datcuocRepository.findByEmail(email);
	    	if(datcuoc==null){
	    		return false;
	    	}
	        return true;
	    }
	    
	    public void saveDatcuoc(DatCuoc datcuoc) {
	    	datcuocRepository.save(datcuoc);
	    }

	 
	    public void deleteDatCuoc(DatCuoc datcuoc) {
	    	datcuocRepository.delete(datcuoc);
	    }
	    
	    public List<DatCuoc> getAlldatcuoc() {
	        List<DatCuoc> allPhong= datcuocRepository.findAll();
	        return allPhong;
	    }
	    
	    public List<DatCuoc> getAlldatcuocbyban(int maban) {
	    	
	    	 List<DatCuoc> allPhong= datcuocRepository.findAll();
	    	 ArrayList<DatCuoc> elements = new ArrayList<DatCuoc>();
	    	
	    	 for (DatCuoc datCuoc : allPhong) {
				if(datCuoc.getMaBan() == maban){
					elements.add(datCuoc);
				}
			}
			return elements;
	    }
	    
	    public Double sum(String email) {
	    	DatCuoc datcuoc = datcuocRepository.findByEmail(email);
	    	return (Double) datcuoc.get_1den3trang() + datcuoc.get_1trang3den() + datcuoc.get_4den() + datcuoc.get_4trang() + datcuoc.getChan() + datcuoc.getLe();
			
		}
	    public int soNguoiChoi(int maban) {
	    	 List<DatCuoc> allPhong= datcuocRepository.findAll();
	    	 int i =0;
	    	 for (DatCuoc datCuoc : allPhong) {
				if(datCuoc.getMaBan() == maban){
					i++;
				}
			}
	    	 return i;
		}
	    public DatCuoc findDatCuocbyid(long id){
	    	return datcuocRepository.findById(id);
	    	
	    }
	    
	    public void deleDatCuoc(DatCuoc datcuoc){
	    	datcuocRepository.delete(datcuoc);
	    }
}
