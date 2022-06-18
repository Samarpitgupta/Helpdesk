package com.iconnate.dao;

import java.util.List;

import com.iconnate.dto.UserDto;

public interface LoginDAO {

	public List<UserDto> getUserDetailsByUsernameWithPassword(String username, String password);
}
