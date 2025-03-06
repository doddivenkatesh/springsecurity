package com.springsecurity.springsecurity.service;

import java.util.List;

import com.springsecurity.springsecurity.document.entity.Customer;
import com.springsecurity.springsecurity.dto.CustomerDto;

public interface CustomerService {

	public String registerUser(Customer customer);


	Customer getByCustomerId(Long id);


	public List<Customer> getAllCustomers();




	public Customer updateCustomer(Long id, Customer updatedCustomer);


	public String deleteCustomer(Long id);




	public String verifyUser(String emailAddress, String password);
}
