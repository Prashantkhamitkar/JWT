package com.security.app.userdetails;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.app.model.Appuser;

//UserDetails is interface 
public class CustomUserDetails implements UserDetails{
private Appuser appuser;

public CustomUserDetails(Appuser user) {
	this.appuser=user;
}
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return List.of(new SimpleGrantedAuthority(appuser.getRole().name()));
}

@Override
public String getPassword() {
	// TODO Auto-generated method stub
	return appuser.getPassword();
}

@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return appuser.getEmail();
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
