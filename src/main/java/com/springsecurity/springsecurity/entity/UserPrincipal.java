package com.springsecurity.springsecurity.entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails{

<<<<<<< HEAD
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user;
=======
	 private Users user;
>>>>>>> 19f2d9facef8610c7b3ffc5ffb35b4cfbd7da5ca

	    public UserPrincipal(Users user) {
	        this.user = user;
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return Collections.singleton(new SimpleGrantedAuthority("USER"));
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
}
