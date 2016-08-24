package com.bitwise.OnlineShoppingCart.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bitwise.OnlineShoppingCart.model.Login;

@Component
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {

		return Login.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name", "username is required for login.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password", "password is required.");
		System.out.println(" Validator");
	}
}
