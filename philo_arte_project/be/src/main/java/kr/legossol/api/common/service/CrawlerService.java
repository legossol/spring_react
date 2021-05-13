package kr.legossol.api.common.service;

import kr.legossol.api.common.domain.Crawler;

import java.io.IOException;
import java.util.List;

public interface CrawlerService {
    public List<?> scraping(Crawler crawler) throws IOException;
}
