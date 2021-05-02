package kr.legossol.api.news.service;

import kr.legossol.api.common.domain.Crawler;
import kr.legossol.api.common.service.AbstractService;
import kr.legossol.api.common.service.CrawlerService;
import kr.legossol.api.common.service.CrawlerServiceImpl;
import kr.legossol.api.news.domain.News;
import kr.legossol.api.news.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Log
@Service @RequiredArgsConstructor
public class NewsServiceImpl extends AbstractService<News> implements NewsService {

    private final NewsRepository repository;


    @Override
    public Long save(News news) {
        return (repository.save(news) != null) ? 1L : 0L;
    }
    @Override
    public List<News> saveAll(Crawler crawler) throws IOException {
        Document document = CrawlerServiceImpl.connectUrl(crawler.getUrl()); // "https://news.daum.net/society"
        repository.deleteAll();
        Elements elements = document.select(crawler.getCssQuery());
        // "div.item_mainnews>div.cont_thumb>strong.tit_thumb>a"
        List<News> newslist = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            News news = new News();
            news.setTitle(elements.get(i).text());
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory(crawler.getCategory());
            newslist.add(news);
            // repository.save(news);
        }
        return newslist;
    }

    @Override
    public Page<News> findAll(final Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<News> findById(long id) {
        return repository.findById(id);
    }



    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public Optional<News> getOne(long id) {
        return Optional.empty();
    }


    @Override
    public Long delete(News news) {
        repository.delete(news);
        return (findById(news.getNewsId()).orElse(null) == null) ? 1L : 0L;
    }

    @Override
    public Boolean existsById(long id) {
        return repository.existsById(id);
    }
    @Override
    public List<News> newsFindAll() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void crawlingHome() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public Page<News> findAll(
            org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void optionalInit(String newsNo) {
        // TODO Auto-generated method stub
        
    }
}