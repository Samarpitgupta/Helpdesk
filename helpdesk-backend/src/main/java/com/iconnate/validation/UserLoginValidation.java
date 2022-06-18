package com.iconnate.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.iconnate.model.response.LoginResponse;
import com.iconnate.model.response.ResponseStatus;

/**
 * @author samarpit
 * 
 */
public class UserLoginValidation {
	
	private UserLoginValidation() {
	}

	public static ResponseEntity<LoginResponse> doLoginValidation(String userName, String password) {
		ResponseStatus status = new ResponseStatus();
		LoginResponse loginResponse = new LoginResponse();

		if (password.isEmpty() && userName.isEmpty()) {
			status.setErrorMessage("please provide both the fields");
			status.setStatusCode(400);
			loginResponse.setStatus(status);
			return new ResponseEntity<>(loginResponse, HttpStatus.BAD_REQUEST);
		} else {
			if (userName.isEmpty()) {
				status.setErrorMessage("username field is empty");
				status.setStatusCode(400);
				loginResponse.setStatus(status);
				return new ResponseEntity<>(loginResponse, HttpStatus.BAD_REQUEST);
			}
			if (password.isEmpty()) {
				status.setErrorMessage("password field is empty");
				status.setStatusCode(400);
				loginResponse.setStatus(status);
				return new ResponseEntity<>(loginResponse, HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(loginResponse, HttpStatus.ACCEPTED);
		}
	}
}
