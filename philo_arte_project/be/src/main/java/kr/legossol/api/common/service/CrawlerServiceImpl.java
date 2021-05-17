package kr.legossol.api.common.service;

import java.io.IOException;

import kr.legossol.api.common.domain.Crawler;
import kr.legossol.api.review.domain.Review;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrawlerServiceImpl implements CrawlerService {

    public static Document connectUrl(String url) throws IOException {
        return Jsoup.connect(url).method(Connection.Method.GET)
                .userAgent("Mozilla/5.0 (X11; Linux x86_64; rv:10.0) " + "Gecko/20100101 Firefox/10.0 "
                        + "AppleWebKit/537.36 (KHTML, like Gecko) " + "Chrome/51.0.2704.106 Safari/537.36")
                .execute().parse();
    }

    @Override
    public List<?> scraping(Crawler crawler) throws IOException {
        Document document = connectUrl(crawler.getUrl()); // "https://news.daum.net/society"
        // List<>
        Elements elements = document.select(crawler.getCssQuery());
        // "div.item_mainnews>div.cont_thumb>strong.tit_thumb>a"
        for (int i = 0; i < elements.size(); i++) {
            Review review = new Review();
            // review.setTitle(elements.get(i).text());
            // review.setAddress(elements.get(i).attr("href"));
            // review.setCategory(crawler.getCategory());
        }
        // return repository.count() > 0L ? 1L : 0L;
        return null;
    }
}