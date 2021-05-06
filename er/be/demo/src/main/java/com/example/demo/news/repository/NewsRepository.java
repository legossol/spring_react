package com.example.demo.news.repository;

import com.example.demo.news.domain.News;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface NewsCustomRepository {

}

@Repository
public interface NewsRepository extends JpaRepository<News, Long>, NewsCustomRepository {
    public News findByNewsId(String newsId);

}
