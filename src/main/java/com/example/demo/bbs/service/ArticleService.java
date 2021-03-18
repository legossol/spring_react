package com.example.demo.bbs.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.bbs.domain.Article;

public interface ArticleService {
	public Optional<Article> findById(long id);
	public List<Article> findAll();
	public long count();
	public Article getOne(long id);
	public void deleteById(long id);
	public Article save(Article entity);
	public boolean existsById(long id);
	
}
