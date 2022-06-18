package com.iconnate.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author samarpit
 *
 */
@ApiModel
public class Role {

	@ApiModelProperty(notes = "role id")
	private long id;
	@ApiModelProperty(notes = "role name")
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
