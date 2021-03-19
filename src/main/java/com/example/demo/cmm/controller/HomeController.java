package com.example.demo.cmm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cmm.util.Proxy;

import lombok.RequiredArgsConstructor;
@RestController
public class HomeController extends Proxy{
	
	@GetMapping("/")
	public String init() {
		print.accept("=============================");
		print.accept("===== Boot Initialized =====");
		print.accept("=============================");
		return "Hello React";
	}

}