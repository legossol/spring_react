package com.example.demo.news.domain;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Component
@Getter
//@Builder(access = AccessLevel.PRIVATE)
public class NewsDto {

    private long newsId;
    private String category;
    private String title;
    private String address;

    // public static NewsDto of(News news) {
    //     return NewsDto.builder().newsId(news.getNewsId()).category(news.getCategory()).title(news.getTitle())
    //             .address(news.getAddress()).build();
    // };

}