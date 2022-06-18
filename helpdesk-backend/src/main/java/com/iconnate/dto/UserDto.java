package com.iconnate.dto;

import java.io.Serializable;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author samarpit
 *
 */

@ApiModel(description = "All details about the user")
@Component
public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(notes = "user ID")
	private long userId;
	@ApiModelProperty(notes = "role ID")
	private long roleId;
	@ApiModelProperty(notes = "company ID")
	private long companyId;
	@ApiModelProperty(notes = "name")
	private String name;
	@ApiModelProperty(notes = "password")
	private String password;
	@ApiModelProperty(notes = "email")
	private String email;
	@ApiModelProperty(notes = "avatar")
	private String avatar;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}