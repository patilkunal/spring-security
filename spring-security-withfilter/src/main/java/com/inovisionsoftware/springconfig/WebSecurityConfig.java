package com.inovisionsoftware.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@EnableWebSecurity
public class WebSecurityConfig {

	//@Bean
	public UserDetailsService userDetailsService() throws Exception {
		InMemoryUserDetailsManager mgr = new InMemoryUserDetailsManager();
		mgr.createUser(User.withUsername("user1").password("password1").roles("USER").build());
		return mgr;
	}
	
}
