package com.inovisionsoftware.model;

import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetails;

public class CustomUser implements UserDetails {

	private static final long serialVersionUID = -3612496347971605140L;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private Collection<Role> authorities;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<Role> authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public Collection<Role> getAuthorities() {
		return authorities;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
