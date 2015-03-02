package org.baeldung.persistence.service;

import javax.transaction.Transactional;

import org.baeldung.persistence.dao.AdminRepository;
import org.baeldung.persistence.dao.UserRepository;
import org.baeldung.persistence.model.Admin;
import org.baeldung.persistence.model.Role;
import org.baeldung.persistence.model.User;
import org.baeldung.validation.service.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdminService {
	
	   @Autowired
	    private AdminRepository repository;
	 
	   public Admin registerNewAdmin(AdminDto admindto) throws EmailExistsException {
	        Admin newAdmin = new Admin();
	        newAdmin.set_1den3trang((double) 1);
	        newAdmin.set_1trang3den((double) 1);
	        newAdmin.set_4den((double) 1);
	        newAdmin.set_4trang((double) 1);
	        newAdmin.setChan((double) 1);
	        newAdmin.setGiay(15);
	        newAdmin.setHoahong((double) 1);
	        newAdmin.setLe((double) 1);
	        newAdmin.setPhut( 1);
	        newAdmin.setEditor(" ");
	        newAdmin.setTitile(" ");
	        newAdmin.setNapxueditor(" ");
	        newAdmin.setNapxueditor(" ");
	        return repository.save(newAdmin);
	    }
	   
	    public void saveAdmin(Admin admin) throws EmailExistsException {
	   
	    		repository.save(admin);
			
	    	
	    }
	    public Admin getadmin(int id) throws EmailExistsException {
	    	return repository.findById(id);
	    }
}
