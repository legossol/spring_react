package com.example.demo.cral.controller;

import com.example.demo.cral.service.CralServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.models.Model;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CralController {
    public static  void main(String[] args) {
        private final CralServiceImpl service;

    public String korea(Model model) throws IOException {

        List<Cral> cralList = service.getKoreaCovidDatas();

        model.addAttribute("koreaStats", koreaStatsList);

        return "korea";

    }
        
    }
    
}
