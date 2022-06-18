package com.iconnate.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "contains status message")
public class ResponseHelpDesk {

	@ApiModelProperty(notes = "message to show helpdesk operation status")
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
