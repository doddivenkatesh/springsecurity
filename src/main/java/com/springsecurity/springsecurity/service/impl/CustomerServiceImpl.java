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

	@Autowired
	public CustomerDao customerDao;
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	private final BCryptPasswordEncoder passwordEncoder;

	public CustomerServiceImpl() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	Logger logger = (Logger) LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Override
	public String registerUser(Customer customer) {
		logger.info("Attempting to register customer with email: {}", customer.getEmailAddress());

		Optional<Customer> existingCustomer = customerDao.findByEmail(customer.getEmailAddress());

		if (existingCustomer.isPresent()) {
			logger.warn("Registration failed: Customer with email {} already exists", customer.getEmailAddress());
			logger.info("Customer roles assigned: {}", customer.getRoles());

			throw new CustomerNotFoundException("User already exists");
		}

		logger.debug("Hashing password for customer: {}", customer.getEmailAddress());
		String hashedPassword = passwordEncoder.encode(customer.getPassword());

		Customer newCustomer = new Customer();
		newCustomer.setFirstName(customer.getFirstName());
		newCustomer.setLastName(customer.getLastName());
		newCustomer.setEmailAddress(customer.getEmailAddress());
		newCustomer.setPassword(hashedPassword);
		newCustomer.setRoles(customer.getRoles());

		customerDao.save(newCustomer);
		logger.info("Customer registered successfully: ID={}, Email={}", newCustomer.getCustomerId(),
				newCustomer.getEmailAddress());
		logger.info("Customer roles assigned: {}", newCustomer.getRoles());
		return "User registered successfully";

		// logger.error("Unexpected error occurred while registering customer: {}",
		// e.getMessage(), e);

	}

	@Override
	public Customer getByCustomerId(Long id) {
	    logger.info("Fetching customer details for ID: {}", id);

	    Customer customer = customerDao.findById(id)
	            .orElseThrow(() -> {
	                logger.warn("Customer not found for ID: {}", id);
	                return new CustomerNotFoundException("Customer not found for the given id: " + id);
	            });

	    logger.info("Customer retrieved successfully: ID={}, Email={}, Roles={}", 
	                customer.getCustomerId(), customer.getEmailAddress(), customer.getRoles());

	    return customer;
	}


	@Override
	public List<Customer> getAllCustomers() {
	    logger.info("Fetching all customers from the database");

	    List<Customer> customers = customerDao.findAll();

	    if (customers.isEmpty()) {
	        logger.warn("No customers found in the database");
	    } else {
	        logger.info("Total customers retrieved: {}", customers.size());
	        for (Customer customer : customers) {
	            logger.debug("Customer: ID={}, Email={}, Roles={}", 
	                         customer.getCustomerId(), customer.getEmailAddress(), customer.getRoles());
	        }
	    }

	    return customers;
	}


	@Override
	public Customer updateCustomer(Long id, Customer updatedCustomer) {
	    logger.info("Updating customer with ID: {}", id);

	    return customerDao.findById(id).map(customer -> {
	        logger.info("Existing customer details - ID: {}, Email: {}, Name: {} {}", 
	                    customer.getCustomerId(), customer.getEmailAddress(), customer.getFirstName(), customer.getLastName());

	        customer.setFirstName(updatedCustomer.getFirstName());
	        customer.setLastName(updatedCustomer.getLastName());
	        customer.setEmailAddress(updatedCustomer.getEmailAddress());
	        customer.setPassword(updatedCustomer.getPassword());

	        Customer savedCustomer = customerDao.save(customer);
	        logger.info("Customer updated successfully - ID: {}, New Email: {}, New Name: {} {}", 
	                    savedCustomer.getCustomerId(), savedCustomer.getEmailAddress(), savedCustomer.getFirstName(), savedCustomer.getLastName());

	        return savedCustomer;
	    }).orElseThrow(() -> {
	        logger.error("Customer not found for the given ID: {}", id);
	        return new ProductNotFoundException("Customer not found for the given id: " + id);
	    });
	}

	@Override
	public String deleteCustomer(Long id) {
	    logger.info("Attempting to delete customer with ID: {}", id);

	    return customerDao.findById(id).map(customer -> {
	        logger.info("Customer found - ID: {}, Email: {}, Name: {} {}", 
	                    customer.getCustomerId(), customer.getEmailAddress(), customer.getFirstName(), customer.getLastName());

	        customerDao.deleteById(id);
	        logger.info("Customer successfully deleted - ID: {}", id);

	        return "Customer successfully deleted";
	    }).orElseThrow(() -> {
	        logger.error("Customer not found for deletion - ID: {}", id);
	        return new CustomerNotFoundException("Customer ID not found");
	    });
	}


	public String verifyUser(String emailAddress, String password) {
	    logger.info("Verifying user login attempt - Email: {}", emailAddress);

	    Optional<Customer> optionalCustomer = customerDao.findByEmail(emailAddress);

	    if (optionalCustomer.isPresent()) {
	        Customer customer = optionalCustomer.get();
	        logger.info("User found - ID: {}, Email: {}, Name: {} {}",
	                    customer.getCustomerId(), customer.getEmailAddress(), customer.getFirstName(), customer.getLastName());

	        // Verify password using BCrypt
	        if (passwordEncoder.matches(password, customer.getPassword())) {
	            logger.info("Successful login - Email: {}", emailAddress);
	            return "Successfully logged in";
	        } else {
	            logger.warn("Failed login attempt - Incorrect password for Email: {}", emailAddress);
	            throw new CustomerNotFoundException("Invalid email or password");
	        }
	    } else {
	        logger.error("Failed login attempt - User not found for Email: {}", emailAddress);
	        throw new CustomerNotFoundException("User not found");
	    }
	}

}
