package com.inovisionsoftware.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.inovisionsoftware.model.CustomUser;
import com.inovisionsoftware.model.Role;

public class CustomUserService implements UserDetailsService {

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Write your DB call code to get the user details(user and roles) from
		// DB ,But I am just hard coding it.
		CustomUser user = new CustomUser();
		user.setFirstName("kb");
		user.setLastName("gc");
		user.setUsername("kb");
		user.setPassword("1234");
		Role r = new Role();
		r.setName("ROLE_USER");
		List<Role> roles = new ArrayList<Role>();
		roles.add(r);
		user.setAuthorities(roles);
		return user;
	}

}