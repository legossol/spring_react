package com.example.demo.cmm.service;

import com.example.demo.cmm.domain.Crawler;

import java.io.IOException;
import java.util.List;

public interface CrawlerService {
    public List<?> scrapBugs(Crawler crawler) throws IOException;
}
