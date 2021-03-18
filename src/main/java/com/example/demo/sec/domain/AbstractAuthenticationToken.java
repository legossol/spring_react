package com.example.demo.sec.domain;

import java.util.Collection;

public class AbstractAuthenticationToken implements Authentication   {
// CredentialsContainer
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
/*
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}
*/
	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

}
