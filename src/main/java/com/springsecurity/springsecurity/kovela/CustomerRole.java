package com.springsecurity.springsecurity.kovela;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
//
//@Data
//@Entity
//public class CustomerRole {
//
//	    @Id
//	    @GeneratedValue
//	    @Column(name = "CUSTOMER_ROLE_ID")
//	    private  Long id;
//	    
//	    @ManyToOne(targetEntity = Customer.class, optional = false)
//	    @JoinColumn(name = "CUSTOMER_ID")
//	    protected Customer customer;
//	    
//	    @ManyToOne(targetEntity = Role.class, optional = false)
//	    @JoinColumn(name = "ROLE_ID")
//	    protected Role role;
//}
