package com.springsecurity.springsecurity.kovela;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomerUserDetails extends User{

	 
	private static final long serialVersionUID = 1L;
	protected Long id;
	
	public CustomerUserDetails(Long id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this(username, password, true, true, true, true, authorities);
    }
    
	public CustomerUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.id=id;
	}
	 public CustomerUserDetails withId(Long id) {
	        setId(id);
	        return this;
	    }
	 
	 public Long getId() {
	        return id;
	    }
	 
	 public void setId(Long id) {
	        this.id = id;
	    }
	 

	



}
