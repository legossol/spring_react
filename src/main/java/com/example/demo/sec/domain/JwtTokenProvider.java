package com.example.demo.sec.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
	@Value("spring.jwt.secret")
    private String SECRET_KEY;
    private long tokenValidMilisecond = 1000L * 60 * 60; // 1시간만 토큰 유효
    private final UserDetailsService userDetailsService;

}
