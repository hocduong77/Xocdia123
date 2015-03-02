package org.baeldung.validation.service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.baeldung.persistence.service.ForgetP;
import org.baeldung.persistence.service.UserDto;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
    	try{
        UserDto user = (UserDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    	}catch(Exception ex){
    		ForgetP user = (ForgetP) obj;
            return user.getPass().equals(user.getRepass());
    	}
		
    }
}
