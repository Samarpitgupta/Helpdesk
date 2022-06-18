package com.iconnate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iconnate.model.LoginUser;
import com.iconnate.model.response.LoginResponse;
import com.iconnate.serviceImpl.UserServiceImpl;
import com.iconnate.validation.RefreshTokenValidation;
import com.iconnate.validation.UserLoginValidation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author samarpit
 *
 */

@Api(value = "HelpDesk", description = "")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

//	@Autowired
//	private AuthenticationManager authenticationManager;

//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserServiceImpl userServiceImple;

	@PostMapping(value = "/test")
	public String test() {
		return "Test Success";
	}

	// @ApiImplicitParams({ @ApiImplicitParam(name = "authorization", value =
	// "Bearer JWT Token", paramType = "header") }) //check
	@PostMapping(value = "/userLogin", produces = "application/json")
	@ApiOperation(value = "user authentication and authorization", response = LoginResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "logged in successful"),
			@ApiResponse(code = 400, message = "You are passing blank user credentials "),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<LoginResponse> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

		ResponseEntity<LoginResponse> loginEntiyResponse;
		// Validation
		loginEntiyResponse = UserLoginValidation.doLoginValidation(loginUser.getUsername(), loginUser.getPassword());
		if (loginEntiyResponse.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
			return loginEntiyResponse;
		}
		loginEntiyResponse = userServiceImple.logInAuthentication(loginUser);
		return loginEntiyResponse;
	}

	@ApiOperation(value = "renewing jwt token validity", response = LoginResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid refresh token"),
			@ApiResponse(code = 502, message = "Not a valid token"),
			@ApiResponse(code = 202, message = "logged in successful") })
	@PostMapping(value = "/refreshToken", produces = "application/json")
	public ResponseEntity<LoginResponse> refreshToken(@RequestParam String refereshToken)
			throws AuthenticationException {

		// validation
		ResponseEntity<LoginResponse> loginEntiyResponse;
		loginEntiyResponse = RefreshTokenValidation.doRefreshTokenValidation(refereshToken);
		return loginEntiyResponse;
	}
}
