package com.springsecurity.springsecurity.dynamicproxy;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class ITEmployee implements IEmployee{
	
	private int id;
	private String name;
	private double salary;

	@Override
	public void giveHike(double amount) {
		this.salary=this.salary+amount;
	}

	@Override
	public void payCut(double amount) {
		this.salary= this.salary-amount;
	}

	
	

}
