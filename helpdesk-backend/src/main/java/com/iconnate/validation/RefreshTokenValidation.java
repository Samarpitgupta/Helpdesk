package com.iconnate.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.iconnate.model.response.LoginResponse;
import com.iconnate.model.response.ResponseStatus;
import com.iconnate.utils.JwtTokenUtil;

/**
 * @author samarpit
 *
 */
public class RefreshTokenValidation {
	private RefreshTokenValidation() {
	}

	public static ResponseEntity<LoginResponse> doRefreshTokenValidation(String refereshToken) {
		JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
		if (refereshToken == null || refereshToken.length() == 0) {
			ResponseStatus status = new ResponseStatus();
			LoginResponse loginResponse = new LoginResponse();

			status.setErrorMessage("Invalid refresh token");
			status.setStatusCode(400);
			loginResponse.setStatus(status);

			return new ResponseEntity<>(loginResponse, HttpStatus.BAD_REQUEST);
		}

		String userName = jwtTokenUtil.getUsernameFromToken(refereshToken);

		if (userName == null) {
			ResponseStatus status = new ResponseStatus();
			LoginResponse loginResponse = new LoginResponse();

			status.setErrorMessage("Not a valid token");
			status.setStatusCode(400);
			loginResponse.setStatus(status);

			return new ResponseEntity<>(loginResponse, HttpStatus.BAD_GATEWAY);
		}
		final String token = jwtTokenUtil.generateToken(userName);
		final String refreshToken = jwtTokenUtil.generateToken(userName);

		LoginResponse loginResponse = new LoginResponse();
		ResponseStatus status = new ResponseStatus();

		loginResponse.setUserName(userName);
		loginResponse.setToken(token);
		loginResponse.setRefreshToken(refreshToken);
		status.setStatusMessage("logged in successful");
		loginResponse.setStatus(status);

		return new ResponseEntity<>(loginResponse, HttpStatus.ACCEPTED);
	}

}
