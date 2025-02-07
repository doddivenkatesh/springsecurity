package com.springsecurity.springsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.springsecurity.document.entity.Customer;
import com.springsecurity.springsecurity.repo.CustomerDao;
import com.springsecurity.springsecurity.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	public CustomerDao customerDao;
	
	@Override
	public Customer save(Customer customer) {
		return customerDao.save(customer);
	}

}
