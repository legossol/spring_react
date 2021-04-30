package kr.legossol.api.news.service;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import kr.legossol.api.common.domain.Crawler;
import kr.legossol.api.news.domain.News;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface NewsService {
    List<News> newsFindAll();
    void crawlingHome();
    List<News> saveAll(Crawler crawler) throws IOException;
    Page<News> retrieve(final Pageable pageable);
    void optionalInit(String newsNo);
}