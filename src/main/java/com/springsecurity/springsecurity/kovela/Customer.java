package com.springsecurity.springsecurity.kovela;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue
	private Long id;
	private String username;
}
