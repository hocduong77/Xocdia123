package org.baeldung.persistence.service;

import java.util.List;

import org.baeldung.persistence.model.DatCuoc;
import org.baeldung.persistence.model.User;
import org.baeldung.persistence.model.VerificationToken;
import org.baeldung.validation.service.EmailExistsException;

public interface IUserService {

    User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void deleteUser(User user);
    void createVerificationTokenForUser(User user, String token);
    boolean emailExist(String email);
    
    VerificationToken getToken(User user);
    User getEuser(String email);
    User getiduser(Long id);
    VerificationToken getVerificationToken(String VerificationToken);
     List<User> getAlluser();
     
    
}
