package com.java.backend.app.spring_java_backend.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtHelper {

	// Token validity duration (5 hours)
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	// Secret key (should be Base64-encoded)
	private String secret = "afafasfafafasfasfasfafacasdasfasxASFACASDFACASDFASFASFDAFASFASDAADSCSDFADCVSGCFVADXCcadwavfsfarvf";

	// Retrieve username from JWT token
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	// Retrieve expiration date from JWT token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	// For retrieving any information from the token, the secret key is required
	private Claims getAllClaimsFromToken(String token) {
		Key signingKey = getSigningKey();
		return Jwts.parser()
				.setSigningKey(signingKey)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}

	// Check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	// Generate token for user
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}

	// While creating the token:
	// 1. Define claims (Issuer, Expiration, Subject, and ID)
	// 2. Sign the JWT using HS512 algorithm and secret key
	// 3. Compact the JWT to a URL-safe string
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		Key signingKey = getSigningKey();
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(signingKey, SignatureAlgorithm.HS512)
				.compact();
	}

	// Validate token
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	// Convert the secret key string to a Key object
	private Key getSigningKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secret); // Decode the Base64 secret
		return Keys.hmacShaKeyFor(keyBytes);             // Generate an HMAC key
	}
}
