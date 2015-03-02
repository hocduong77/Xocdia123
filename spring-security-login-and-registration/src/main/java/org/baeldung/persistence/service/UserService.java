package org.baeldung.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.baeldung.hashing.HashGenerator;
import org.baeldung.persistence.dao.PhongRepository;
import org.baeldung.persistence.dao.UserRepository;
import org.baeldung.persistence.dao.VerificationTokenRepository;
import org.baeldung.persistence.model.DatCuoc;
import org.baeldung.persistence.model.Role;
import org.baeldung.persistence.model.User;
import org.baeldung.persistence.model.VerificationToken;
import org.baeldung.validation.service.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private PhongRepository phongRepository;
    
    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Autowired
    private HashGenerator hashGenerator;

    @Override
    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException("There is an account with that email adress: " + accountDto.getEmail());
        }
        User user = new User();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        String hashedPassword = hashGenerator.getHashedPassword(accountDto.getPassword());
        user.setPassword(hashedPassword);
        user.setEmail(accountDto.getEmail());
        if(accountDto.getEmail().equals("xocdia123.sg@gmail.com")){
        user.setRole(new Role(Integer.valueOf(2), user));   
        }else {
        	 user.setRole(new Role(Integer.valueOf(1), user));
		}
        user.setPhone(accountDto.getPhone());
        user.setXu(accountDto.getXu());
        user.setRuttien(accountDto.getRuttien());
        user.setFullname(accountDto.getFullname());
        user.setTiendachuyen((double) 0);
       user.setStatusdachuyen(0);
       user.setLoginstatus(0);
        return repository.save(user);
    }

    @Override
    public User getUser(String verificationToken) {
        User user = tokenRepository.findByToken(verificationToken).getUser();
        return user;
    }

    @Override
    public VerificationToken getVerificationToken(String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }
    @Override
    public void saveRegisteredUser(User user) {
        repository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        repository.delete(user);
    }
    
   

    @Override
    public void createVerificationTokenForUser(User user, String token) {
        VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
    }
    
    @Override
    public boolean emailExist(String email) {
        User user = repository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

	@Override
	public VerificationToken getToken(User user) {
		
		return tokenRepository.findByUser(user);
	}

	@Override
	public User getEuser(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmail(email);
	}
	@Override
	 public List<User> getAlluser() {
	    	
    	 List<User> alluser= repository.findAll();
    	
		return alluser;
    }
	
	 @Override
	 public  User getiduser(Long id) {
	    	
    	 User user = repository.findById(id);
    	
		return user;
    }
	

}
