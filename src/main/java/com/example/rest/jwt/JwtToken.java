package com.example.rest.jwt;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtToken {

	
	public static String getToken(String username, String password) {
		String jwtToken = Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 100000000))
				.signWith(SignatureAlgorithm.HS512, "secretkey").compact();
		return jwtToken;
	}
}
