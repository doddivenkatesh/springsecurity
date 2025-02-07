package com.springsecurity.springsecurity.kovela;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Role {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	private String roleName;
	private String name;
	
	 @ManyToOne(targetEntity = Customer.class, optional = false)
	    @JoinColumn(name = "CUSTOMER_ID")
	    protected Customer customer;

}
