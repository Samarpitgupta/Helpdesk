package com.iconnate.utils;

/**
 * 
 * @author samarpit
 *
 */
public interface Constants {

	String HEADER_STRING = "Authorization";
	String AUTHORITIES_KEY = "scopes";
	String BASE_PACKAGE = "com.iconnate";
	long ACCESS_TOKEN_VALIDITY_SECONDS = 30 * 60 * 60 * 1000;
	long ACCESS_REFRESH_TOKEN_VALIDITY_SECONDS = 30 * 24 * 60 * 60 * 1000;
	String SIGNING_KEY = "helpdesk";
	String JWT_ISSUER = "http://iconnate.com";
	String JWT_GRANTED_AUTHORITY = "ROLE_ADMIN";
	String TOKEN_PREFIX = "Bearer ";
}
