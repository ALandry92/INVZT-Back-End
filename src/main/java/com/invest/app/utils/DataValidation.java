package com.invest.app.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.invest.app.model.Users;
import com.invest.app.repository.UserRepository;


public class DataValidation implements Validator {
		
		@Autowired
		public UserRepository userRepository;
		
		String emailRegex ="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		String passwordRegex ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$";
		
		//String phoneRegex ="\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
				
		public boolean supports(Class<?> clazz) {
			return Users.class.equals(clazz);
		}

		public void validate(Object o, Errors errors) {
			Users user = (Users) o;
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fname", "size.user.fname");		
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lname", "size.user.lname");			
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");		
			if (userRepository.findByEmail(user.getEmail()).isPresent()) {
		    	errors.rejectValue("email", "size.user.unique");
		    }
			
	          
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password2", "NotEmpty");
	        if (!user.getPassword2().equals(user.getPassword())) {
		    	errors.rejectValue("password2", "match.user.password2");
		    }
	        
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
			if(!user.getEmail().matches(emailRegex)) { 
				errors.rejectValue("email","size.user.email"); 
			}
			 
	        
	        if (!user.getPassword().matches(passwordRegex)) {
	        	errors.rejectValue("password", "size.user.password");
		    }
	        
			
			
		}
}

