package com.springsecurity.springsecurity.newconfig;
/*
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.springsecurity.document.entity.Customer;
import com.springsecurity.springsecurity.repo.CustomerDao;

@Service
public class CustomCustomerDetailsService implements UserDetailsService {

	@Autowired
	public final CustomerDao customerDao;

	public CustomCustomerDetailsService(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer user = customerDao.findByEmailAddress(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return new org.springframework.security.core.userdetails.User(user.getEmailAddress(), user.getPassword(),
				new ArrayList<>());
	}
}
*/