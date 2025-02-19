package com.springsecurity.springsecurity.transactions;

import java.util.Date;

import lombok.Data;
@Data

public class Attendence {

	private Date date;
	private boolean isPresent;
	
	Attendence(Date date,boolean isPresent){
		this.date=date;
		this.isPresent=isPresent;
	}
}
