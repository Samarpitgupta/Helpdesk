package com.iconnate.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author samarpit
 *
 */
@ApiModel(description = "contains 'user information', 'jwt token', 'refresh token', 'response status information'")
public class LoginResponse {

	@ApiModelProperty(notes = "user name")
	private String userName;
	@ApiModelProperty(notes = "jwt token")
	private String token;
	@ApiModelProperty(notes = "refresh token")
	private String refreshToken;
	@ApiModelProperty(notes = "response status which contains 'status message' and 'error message'")
	private ResponseStatus status;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}
}
