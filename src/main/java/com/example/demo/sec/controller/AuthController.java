package com.example.demo.sec.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.uss.domain.UserDto;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@PostMapping("/login")
	public void login(@RequestBody UserDto user) {
		Map<String, Object> map = new HashMap<>();
		
	}

}