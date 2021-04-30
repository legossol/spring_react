package kr.legossol.api.news.controller;
import org.springframework.web.bind.annotation.RestController;

import kr.legossol.api.news.domain.*;
import kr.legossol.api.news.service.NewsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Log
@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {
    private final NewsServiceImpl service;
    
    @GetMapping("/{category}/scope")
    public ResponseEntity<Long> crawling(@PathVariable String category) throws Exception {
        System.out.println("******카테고리 " + category);
        

        return ResponseEntity.ok(service.saveAll(category));
    }
}
