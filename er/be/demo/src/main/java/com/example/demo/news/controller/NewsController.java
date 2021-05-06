package com.example.demo.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;

import com.example.demo.cmm.domain.Crawler;
import com.example.demo.news.domain.News;
import com.example.demo.news.service.NewsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log
@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {
    private final NewsServiceImpl service;

    @PostMapping("/scrap")
    public ResponseEntity<List<News>> crawling(@RequestBody Crawler crawler) throws IOException {
        System.out.print("****************** 카테고리 : " + crawler.toString());
        return ResponseEntity.ok(service.saveAll(crawler));
    }

    @PostMapping("")
    public ResponseEntity<Long> post(@RequestBody News news) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("")
    public ResponseEntity<Page<News>> findAll(final Pageable pageable) throws IOException {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @PutMapping("")
    public ResponseEntity<Long> update(@RequestBody News news) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("")
    public ResponseEntity<Long> delete(@RequestBody News news) {
        return ResponseEntity.ok(null);
    }

}
