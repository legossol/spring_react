package com.example.demo.uss.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Component
public class UserDto  implements UserDetails {
	private static final long serialVersionUID = 1L;
	private String user_no;
	private String password;
	private String username;
	private String authority;
	private String name;
	private String email;
	private String birthday;
	private String gender;
	private boolean enabled;
	private boolean accountNonExpire;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean accountNonExpired;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        auth.add(new SimpleGrantedAuthority(authority));
        return auth;
	}

}