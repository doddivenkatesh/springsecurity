package com.springsecurity.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.springsecurity.document.entity.Customer;
import com.springsecurity.springsecurity.publish.EventPublisher;
import com.springsecurity.springsecurity.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	public CustomerService customerService;
	@Autowired
	private EventPublisher eventPublisher;
	
	@PostMapping("/create")
	public Customer save(@RequestBody Customer customer) {
		eventPublisher.publishJTEvent(customer.getEmailAddress());
		return customerService.save(customer);
	}
}
