package com.example.demo.uss.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.uss.domain.UserDto;
@Repository
public class UserRepositoryImpl implements UserCustomRepository{

	@Override
	public UserDto login(String username, String password) {
		return null;
	}



	
}