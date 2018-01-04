package com.valociraptor.ideas.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.valociraptor.ideas.models.User;

@Component
public class UserValidator implements Validator {
	
	
	
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    
    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        System.out.println("Validator");
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
        	System.out.println("Validator2");
            
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }

}
