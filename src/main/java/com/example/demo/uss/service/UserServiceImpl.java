package com.example.demo.uss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.service.AbstractService;
import com.example.demo.uss.domain.User;
import com.example.demo.uss.domain.UserDto;
import com.example.demo.uss.repository.UserRepository;

@Service 
public class UserServiceImpl extends AbstractService<User> implements UserService {
	@Autowired UserRepository repo;
	
	@Override
	public long count() {
		return repo.count();
	}
	@Override
	public boolean existsById(long id) {
		return repo.existsById(id);
	}
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<User> findOne() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public User getOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User save(User entity) {
		// TODO Auto-generated method stub
		return null;
	}
	// UserDetailsService 의 메소드
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto user = repo.findByUsername(username);
		if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return user;
        }
	}
	@Override
	public UserDto login(String username, String password) {
		return repo.login(username, password);
	}
	
	
}