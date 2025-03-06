package com.springsecurity.springsecurity.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecurity.springsecurity.document.entity.Customer;
import com.springsecurity.springsecurity.document.exceptio.CustomerNotFoundException;
import com.springsecurity.springsecurity.document.exceptio.ProductNotFoundException;
import com.springsecurity.springsecurity.repo.CustomerDao;
import com.springsecurity.springsecurity.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	Logger logger = (Logger) LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	public CustomerDao customerDao;
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	private final BCryptPasswordEncoder passwordEncoder;

	public CustomerServiceImpl() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public String registerUser(Customer customer) {
		
		
		if (customerDao.findByEmail(customer.getEmailAddress()).isPresent()) {
			throw new CustomerNotFoundException("User already exists");
		}

		String hashedPassword = passwordEncoder.encode(customer.getPassword()); 
		Customer newCustomer = new Customer();
		newCustomer.setFirstName(customer.getFirstName());
		newCustomer.setLastName(customer.getLastName());
		newCustomer.setEmailAddress(customer.getEmailAddress());
		newCustomer.setPassword(hashedPassword);
		newCustomer.setRoles(customer.getRoles());
		customerDao.save(newCustomer);

		// return "User registered successfully";
		// customer.setPassword(encoder.encode(customer.getPassword()));
		return "User registered successfully";
	}

	@Override
	public Customer getByCustomerId(Long id) {
		logger.info("Getting Customer by ID from db");
		return customerDao.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found for the given id: " + id));
	}

	@Override
	public List<Customer> getAllCustomers() {
		logger.info("Getting all products from db");
		return customerDao.findAll();
	}

	@Override
	public Customer updateCustomer(Long id, Customer updatedCustomer) {
		logger.info("Updating Product for id: " + id);

		return customerDao.findById(id).map(customer -> {
			customer.setFirstName(updatedCustomer.getFirstName());
			customer.setLastName(updatedCustomer.getLastName());
			customer.setEmailAddress(updatedCustomer.getEmailAddress());
			customer.setPassword(updatedCustomer.getPassword());

			return customerDao.save(customer);
		}).orElseThrow(() -> new ProductNotFoundException("Product not found for the given id: " + id));
	}

	@Override
	public String deleteCustomer(Long id) {
		return customerDao.findById(id).map(product -> {
			customerDao.deleteById(id);
			return "Customer successfully deleted";
		}).orElseThrow(() -> new CustomerNotFoundException("Customer ID not found"));
	}

	public String verifyUser(String emailAddress, String password) {
		Optional<Customer> optionalCustomer = customerDao.findByEmail(emailAddress);

		if (optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();

			// Verify password using BCrypt
			if (passwordEncoder.matches(password, customer.getPassword())) {
				return "Successfully logged in";
			} else {
				throw new CustomerNotFoundException("Invalid email or password");
			}
		} else {
			throw new CustomerNotFoundException("User not found");
		}
	}

}
