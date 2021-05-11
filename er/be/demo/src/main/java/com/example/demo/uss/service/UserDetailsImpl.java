package com.example.demo.uss.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.uss.domain.MemberVo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetails{
    private final Long userId;
    private final String username;
    private final String email;
    private final String name;
    @JsonIgnore
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    // public static UserDetailsImpl build(MemberVo user){
    //     List<GrantedAuthority> authorities = user.getRoles().stream()
    //     .map(role -> new SimpleGrantedAuthority(role.getAuthorities))
    //     .collect(Collectors.toList());
    //     return new UserDetailsImpl(user.getUserId(), user.getUsername(), user.getPassword(), user.getName(), email, authorities);
    // }
    
}
