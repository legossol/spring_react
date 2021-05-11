package com.example.demo.uss.service;

import java.util.Optional;

import com.example.demo.uss.domain.MemberVo;
import com.example.demo.uss.repository.MemberRepository;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final MemberRepository repository;
    // @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Optional<MemberVo> user = Optional.ofNullable(repository.findByUsername(username)
        //     .orElseThrow(() -> new UsernameNotFoundException("User not fount with username" + username)));
        
        // return UserDetailsImpl.build(user.get());
        return null;
    }

}
