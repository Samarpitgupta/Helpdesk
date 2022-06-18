package com.iconnate.model.response;

import com.iconnate.dto.UserDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author samarpit
 *
 */
@ApiModel(description = "contains 'response status', 'user details' and 'message'")
public class UserResponse {

	@ApiModelProperty(notes = "")
	private ResponseStatus status;
	@ApiModelProperty(notes = "")
	private UserDto user;
	@ApiModelProperty(notes = "")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto userDto) {
		this.user = userDto;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

}
