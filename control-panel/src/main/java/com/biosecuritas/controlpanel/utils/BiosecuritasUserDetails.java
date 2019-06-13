package com.biosecuritas.controlpanel.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.biosecuritas.controlpanel.db.entities.User;

import java.util.Collection;
import java.util.stream.Collectors;

public class BiosecuritasUserDetails implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936960185787104394L;
	private User user;

	public BiosecuritasUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return user.getAuthorities().stream()
				.map(authority -> new SimpleGrantedAuthority(authority.getName().toString()))
				.collect(Collectors.toList());
	}

	public int getId() {
		return user.getId();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public User getUserDetails() {
		return user;
	}
}