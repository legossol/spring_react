package com.example.demo.uss.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.uss.domain.User;
import com.example.demo.uss.domain.UserDto;

interface UserCustomRepository{
	public UserDto findByUsername(String username);
}
public interface UserRepository extends JpaRepository<User, Long>,
										UserCustomRepository{

}