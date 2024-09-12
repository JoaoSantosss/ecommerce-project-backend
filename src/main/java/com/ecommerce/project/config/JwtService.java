package com.ecommerce.project.config;

import java.security.Key;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	 @Value("${security.jwt.secret-key}")
	 private String secretKey;

	public String extractUsername(String token) {
		return null;
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		return null;
		
	}
	
	private Claims extractAllClaims(String token) {
		
		return Jwts
				.parserBuilder()
				.setSigningKey(getSignKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
		
	}

	private Key getSignKey() {
	
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}



}
