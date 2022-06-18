package com.iconnate.utils;

/**
 * 
 * @author samarpit
 * 
 */
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String CLAIMS_KEY = "scopes";

	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(Constants.SIGNING_KEY).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	public String generateToken(String userName) {
		return doGenerateToken(userName, new Date(System.currentTimeMillis() + Constants.ACCESS_TOKEN_VALIDITY_SECONDS));
	}

	public String generateRefeshToken(String userName) {
		return doGenerateToken(userName,
				new Date(System.currentTimeMillis() + Constants.ACCESS_REFRESH_TOKEN_VALIDITY_SECONDS));
	}

	private String doGenerateToken(String subject, Date expireDate) {

		Claims claims = Jwts.claims().setSubject(subject);
		claims.put(CLAIMS_KEY, Arrays.asList(new SimpleGrantedAuthority(Constants.JWT_GRANTED_AUTHORITY)));

		return Jwts.builder().setClaims(claims).setIssuer(Constants.JWT_ISSUER)
				.setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(expireDate)
				.signWith(SignatureAlgorithm.HS256, Constants.SIGNING_KEY).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
