package com.iconnate.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "contains 'status message' and 'error message' ")
public class ResponseStatus {

	@ApiModelProperty(notes = "")
	private String statusMessage;
	@ApiModelProperty(notes = "")
	private String errorMessage;
	@ApiModelProperty(notes = "")
	private int statusCode = 200;

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
