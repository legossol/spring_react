package kr.legossol.api.review.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.legossol.api.common.domain.Crawler;
import kr.legossol.api.review.domain.Review;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    // private final ReviewServiceImpl service;

    // @PostMapping("/scrap")
    // public ResponseEntity<List<Review>> crawling(@RequestBody Crawler crawler) throws IOException {
    //     System.out.print("****************** 카테고리 : " + crawler.toString());
    //     return ResponseEntity.ok(service.saveAll(crawler));
    // }
}
