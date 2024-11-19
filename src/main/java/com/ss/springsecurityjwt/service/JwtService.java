package com.ss.springsecurityjwt.service;

import com.ss.springsecurityjwt.model.Jwt;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;



public interface JwtService {
	String generatedJwt(Authentication authentication);
	Claims getClaims(String jwt);
	boolean isValidJwt(Jwt jwt);
}