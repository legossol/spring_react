package com.example.demo.bbs.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.criterion.Example;

import com.example.demo.bbs.domain.Board;

public interface BoardService {
	public long count();
	public boolean existsById(long id);
	public List<Board> findAll();
	public Board getOne(long id);
	public List<Board> saveAll(Iterable<Board> entities);
	public void deleteById(long id);
	public Optional<Board> findOne(List<Board> example);
}
