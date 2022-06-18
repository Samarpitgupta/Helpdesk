package com.iconnate.serviceImpl;

import java.util.Arrays;
import java.util.List;

import com.iconnate.daoImpl.LoginDAOImple;
import com.iconnate.dto.UserDto;
import com.iconnate.model.LoginUser;
import com.iconnate.model.response.LoginResponse;
import com.iconnate.service.UserService;
import com.iconnate.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.iconnate.model.response.ResponseStatus;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
    LoginDAOImple userDaoImple;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public UserServiceImpl(LoginDAOImple userDaoImple) {
		this.userDaoImple = userDaoImple;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/* User user = userDaoImple.findByUsername(userId); */
		return new org.springframework.security.core.userdetails.User("Samarpit", "Gupta", getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	// It will call user DAO to get list of UserDtos with the corresponding user
	// fields and return list of UserDtos
	@Override
	public ResponseEntity<LoginResponse> logInAuthentication(LoginUser loginUser) {

		List<UserDto> listUserDto = userDaoImple.getUserDetailsByUsernameWithPassword(loginUser.getUsername(),
				loginUser.getPassword());
		if (listUserDto.isEmpty()) {
			ResponseStatus status = new ResponseStatus();
			status.setErrorMessage("user details are not matched, please enter right details");
			status.setStatusCode(400);
			
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setStatus(status);
			
			return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.NOT_FOUND);
		}
		final String token = jwtTokenUtil.generateToken(loginUser.getUsername());
		final String refreshToken = jwtTokenUtil.generateToken(loginUser.getUsername());
		LoginResponse loginResponse = new LoginResponse();

		ResponseStatus status = new ResponseStatus();
		status.setStatusMessage("user details are matched");
		status.setStatusCode(200);
		loginResponse.setUserName(loginUser.getUsername());
		loginResponse.setToken(token);
		loginResponse.setRefreshToken(refreshToken);
		loginResponse.setStatus(status);
		System.out.println("Token: " + token);
		System.out.println("Refresh Token: " + refreshToken);

		return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.ACCEPTED);
	}

}
