package com.iconnate.config;

/**
 * 
 * @author samarpit
 * 
 */
import java.io.IOException;
import static com.iconnate.utils.Constants.HEADER_STRING;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		// This is invoked when user tries to access a secured REST resource
		// without supplying any credentials
		// We should just send a 401 Unauthorized response because there is no
		// 'login page' to redirect to
		System.out.println("This is header" + " " + response.getHeader(HEADER_STRING));
		System.out.println(response.getOutputStream().toString());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
}
