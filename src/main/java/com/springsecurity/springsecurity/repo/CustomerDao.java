package com.springsecurity.springsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.springsecurity.document.entity.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

}
