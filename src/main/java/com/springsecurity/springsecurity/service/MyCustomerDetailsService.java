package com.springsecurity.springsecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.springsecurity.document.entity.Customer;
import com.springsecurity.springsecurity.entity.CustomerPrinciple;
import com.springsecurity.springsecurity.repo.CustomerDao;
@Service
@Primary
public class MyCustomerDetailsService implements UserDetailsService{

	 @Autowired
	    private CustomerDao customerDao;


	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	     Customer user = customerDao.findByEmailAddress(username);
	        if (user == null) {
	            System.out.println("User Not Found");
	            throw new UsernameNotFoundException("user not found");
	        }
	        
	        return new CustomerPrinciple(user);
	    }

}
