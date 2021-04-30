package kr.legossol.api.news.service;

import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import kr.legossol.api.common.service.AbstractService;
import kr.legossol.api.news.domain.News;
import kr.legossol.api.news.repository.NewsRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.jsoup.*;
@Service @RequiredArgsConstructor
public class NewsServiceImpl extends AbstractService<News> implements NewsService {

    private final NewsRepository repository;

    @Override
    public Document connectUrl(String url) throws IOException{
        
        return Jsoup
        .connect(url)
        .method(Connection.Method.GET)
        .userAgent("Mozilla/5.0 (X11; Linux x86_64; rv:10.0) " +
        "Gecko/20100101 Firefox/10.0 " +
        "AppleWebKit/537.36 (KHTML, like Gecko) " +
        "Chrome/51.0.2704.106 Safari/537.36")
        .execute()
        .parse();
    }

    @Override
    public List<News> newsFindAll() {
        return null;
    }

    @Override
    public void crawlingHome() throws Exception {

    }

    @Override
    public void mainCrawler(String category) throws Exception {

    }

    @Override
    public void daumNews(Elements elements, String category) {

    }

    @Override
    public Optional<News> findByNewsNo(String newsNo) {
        return Optional.ofNullable(repository.findByNewsNo(newsNo));
    }

    @Override
    public void optionalInit(String newsNo) {
        Optional<String> optVal = Optional.empty(); // Optional Initializer
    }

    @Override
    public Long save(News news) {
        return (repository.save(news) != null) ? 1L : 0L;
    }

    @Override
    public Optional<News> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<News> findAll() {
        return repository.findAll();
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public Optional<News> getOne(long id) {
        return Optional.of(repository.getOne(id));
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
    public Long saveAll(String category) throws IOException {
        Document document = connectUrl("https://news.daum.net/" + category);
        repository.deleteAll();
        News news = null;
        Elements elements = document.select("div.item_mainnews>div.cont_thumb>strong.tit_thumb>a");
        int count = 0;

    for (int i = 0; i < elements.size(); i++) {
            news = new News();
            news.setTitle(elements.get(i).text());
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory(category);
            count++;
            System.out.println("********news 정보 : " +news.toString());
            
            // homeNewsRepo.save(homeNews);
        }
        System.out.println("********크롤링 카운팅 : " +count);

        return 0L;
    }
}
