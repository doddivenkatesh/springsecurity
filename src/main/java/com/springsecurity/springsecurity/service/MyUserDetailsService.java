package com.springsecurity.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.springsecurity.entity.UserPrincipal;
import com.springsecurity.springsecurity.entity.Users;
import com.springsecurity.springsecurity.repo.UserRepo;

//@Service
//@Primary 
/* 
public class MyUserDetailsService implements UserDetailsService{
	
	  @Autowired
	    private UserRepo userRepo;


	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Users user = userRepo.findByUsername(username);
	        if (user == null) {
	            System.out.println("User Not Found");
	            throw new UsernameNotFoundException("user not found");
	        }
	        
	        return new UserPrincipal(user);
	    }}
*/

