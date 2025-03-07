package com.springsecurity.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.springsecurity.document.entity.Customer;
import com.springsecurity.springsecurity.document.exceptio.CustomerNotFoundException;
import com.springsecurity.springsecurity.dto.CustomerDto;
import com.springsecurity.springsecurity.publish.EventPublisher;
import com.springsecurity.springsecurity.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	public CustomerService customerService;
	@Autowired
	private EventPublisher eventPublisher;

	@PostMapping("/register")
	public String register(@RequestBody Customer customer) {
		
		return customerService.registerUser(customer);
	}
	
	
//	@PostMapping("/create")
//	public Customer save(@RequestBody Customer customer) {
//		eventPublisher.publishJTEvent(customer.getEmailAddress());
//		return customerService.save(customer);
//	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam String emailAddress, @RequestParam String password) {
		return ResponseEntity.ok(customerService.verifyUser(emailAddress, password));
	}

	@GetMapping("/{id}")
	public Customer findById(@PathVariable("id") Long id) {
		return customerService.getByCustomerId(id);
	}

	@GetMapping
	public List<Customer> getAllProducts() {
		return customerService.getAllCustomers();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateProduct(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
		Customer updatedEntity = customerService.updateCustomer(id, updatedCustomer);
		return ResponseEntity.ok(updatedEntity);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return ResponseEntity.noContent().build();
	}

}
