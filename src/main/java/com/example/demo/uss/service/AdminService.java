package com.example.demo.uss.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.uss.domain.Admin;

public interface AdminService {
	public long count();
	public boolean existsById(long id);
	public List<Admin> findAll();
	public Optional<Admin> findOne();
	public void deleteById(long id);
	public Admin getOne(long id);
	public Admin save(Admin entity);
}
