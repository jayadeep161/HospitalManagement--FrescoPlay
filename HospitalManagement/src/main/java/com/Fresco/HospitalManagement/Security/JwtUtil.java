package com.Fresco.HospitalManagement.Security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	public String generateToken(String useremail) {
		Map<String,Object>Claims= new HashMap<>();
		
		String x=createToken(Claims, useremail);
		
		System.out.println(x);
		
		return x;
		
	}
	
	public String createToken(Map<String,Object> claims,String useremail) {
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(useremail)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
				.signWith(key,SignatureAlgorithm.HS256)
				.compact();
	}
	
	public Claims parseclaims(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}
	
	public Claims getclaim(String token) {
		return this.parseclaims(token);
	}
	
	public String extractusername(String token) {
		return this.getclaim(token).getSubject();
	}
	
	public boolean extracttokenexpire(String token) {
		return this.getclaim(token).getExpiration().before(new Date());
	}
	
	public boolean validatetoken(String username,String token) {
		return username.equals(this.extractusername(token)) && ! this.extracttokenexpire(token);
	}

}
