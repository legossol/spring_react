package kr.legossol.api.bugs.service;

import kr.legossol.api.bugs.domain.Bugs;
import kr.legossol.api.news.domain.News;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface BugsService {
    public Long saveAll(String category) throws IOException;
    public Document connectUrl(String url) throws IOException;
    public List<Bugs> bugsFindAll();
    public void crawlingHome();

    public Optional<Bugs> findByBugsNo(String bugsNo);
    public void optionalinit(String bugs);
}