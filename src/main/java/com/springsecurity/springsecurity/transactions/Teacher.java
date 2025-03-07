package com.springsecurity.springsecurity.transactions;

import java.util.Date;

public class Teacher {

	public static void main(String[] args) {

		Student student = new StudentProxy(new Attendence(new Date(),true));
		student.attendLession();
		
		DailySession dailySession= new   StudentProxy(new Attendence(new Date(),true)) ;
			
	
		dailySession.attendLession();
		
		Customer cust = new Customer(1, "venkatesh", "doddive");
		Customer cust1 = new Customer(new Customer(1, "vickey", "vickey@13"));
		
	}

}
