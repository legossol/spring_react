package kr.legossol.api.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.legossol.api.news.domain.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    News findByNewsNo(String newsNo);
}
