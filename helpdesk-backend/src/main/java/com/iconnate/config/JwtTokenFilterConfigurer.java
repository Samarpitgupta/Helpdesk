package com.iconnate.config;

/**
 * 
 * @author samarpit
 * 
 */

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.iconnate.utils.JwtTokenUtil;

public class JwtTokenFilterConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	private JwtTokenUtil jwtTokenUtil;

	public JwtTokenFilterConfigurer(JwtTokenUtil jwtTokenUtil) {
		this.jwtTokenUtil = jwtTokenUtil;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		JwtAuthenticationFilter customFilter = new JwtAuthenticationFilter(jwtTokenUtil);
		http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
