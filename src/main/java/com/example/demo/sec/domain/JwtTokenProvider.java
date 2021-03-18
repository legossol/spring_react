package com.example.demo.sec.domain;

import java.util.Base64;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
	@Value("spring.jwt.secret")
    private String SECRET_KEY;
    private long tokenValidMilisecond = 1000L * 60 * 60; // 1시간만 토큰 유효
    private final UserDetailsService userDetailsService;
    @PostConstruct
    protected void init() {
    	SECRET_KEY = Base64.getEncoder().encodeToString(SECRET_KEY.getBytes());
    }
    public String createToken(String userPk, Collection<? extends GrantedAuthority> roles) {
    	Claims claims = Jwts.claims().setSubject(userPk);
    	claims.put("roles", roles);
    	Date now = new Date();
    	
    	return Jwts.builder()
    			.setClaims(claims)
    			.setIssuedAt(now)
    			.setExpiration(new Date(now.getTime() + tokenValidMilisecond))
    			.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
    			.compact()
    			;
    }
    

}