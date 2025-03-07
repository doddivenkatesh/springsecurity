package com.springsecurity.springsecurity.document.entity;

import static jakarta.persistence.GenerationType.SEQUENCE;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Customers", schema = "CO")
public class Customer {
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "customerSequence")
	@SequenceGenerator(name = "customerSequence", sequenceName = "ISEQ$$_75864", allocationSize = 1)
	private Long customerId;

	private String emailAddress;

	private String firstName;
	private String lastName;
	
	private String password;
	
	private List<String> roles;
}
