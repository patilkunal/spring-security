package com.inovisionsoftware.model;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
	
	private static final long serialVersionUID = 8756104113077544456L;
	private final String name;

	public Role(String roleName) {
		this.name = roleName;
	}
	
	@Override
	public String getAuthority() {
		return name;
	}
	
	
}
