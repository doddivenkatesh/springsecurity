package com.springsecurity.springsecurity.kovela;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("customerDao")
public interface CustomerDao extends JpaRepository<Customer, Long> {

	Customer readCustomerByUsername(String username );
	

}
