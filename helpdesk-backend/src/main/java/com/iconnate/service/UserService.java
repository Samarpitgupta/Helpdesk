package com.iconnate.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.iconnate.model.LoginUser;
import com.iconnate.model.response.LoginResponse;

@Service
public interface UserService {
	public ResponseEntity<LoginResponse> logInAuthentication(LoginUser loginUser);
}
