package com.example.demo.uss.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.uss.domain.UserDto;


public interface UserService extends UserDetailsService {
	
	public UserDto login(String username, String password);
}