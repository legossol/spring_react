package com.example.demo.cmm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class HomeController {

    @GetMapping("/hello")
    public String hello() {

        return "Hello World";
    }
}
