package com.springsecurity.springsecurity.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springsecurity.springsecurity.document.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

	@Query(value = "SELECT * FROM customers WHERE emailAddress = :emailAddress AND password = :password", nativeQuery = true)
	Customer readCustomerLoginDetails(@Param("emailAddress") String emailAddress, @Param("password") String password);

	Customer findByEmailAddress(String username);

	
	@Query(value = "SELECT * FROM Customers WHERE emailAddress = :emailAddress", nativeQuery = true)
	Optional<Customer> findByEmail(@Param("emailAddress") String email);

}
