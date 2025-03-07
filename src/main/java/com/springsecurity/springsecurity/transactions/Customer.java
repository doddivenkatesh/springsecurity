package com.springsecurity.springsecurity.transactions;

import lombok.Data;

@Data
public class Customer {

	public Customer(int id,String name,String email) {
		this.id= id;
		this.name=name;
		this.email=email;
	}
	public Customer(Customer customer) {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String name;
	private String email;
	
	
}
