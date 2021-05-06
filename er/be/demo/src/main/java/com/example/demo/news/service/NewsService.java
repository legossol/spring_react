package com.example.demo.news.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.demo.cmm.domain.Crawler;
import com.example.demo.news.domain.HomeNews;
import com.example.demo.news.domain.News;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NewsService {

    List<News> saveAll(Crawler crawler) throws IOException;

    Page<News> findAll(final Pageable pageable);
}