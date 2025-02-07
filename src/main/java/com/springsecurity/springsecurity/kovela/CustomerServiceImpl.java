package com.springsecurity.springsecurity.kovela;

import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Resource(name="customerDao")
	private CustomerDao customerDao;
	
	@Override
	public Customer readCustomerByUsername(String username) {
		
		return customerDao.readCustomerByUsername(username);
	}

	

}
