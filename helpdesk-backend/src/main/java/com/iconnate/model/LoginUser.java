package com.iconnate.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Samarpit
 *
 */

@ApiModel(description = "contains required credentials for login")
public class LoginUser {

	@ApiModelProperty(notes = "user name for authentication")
	private String username;
	@ApiModelProperty(notes = "password for authentication")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
