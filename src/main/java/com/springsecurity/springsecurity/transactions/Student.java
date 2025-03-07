package com.springsecurity.springsecurity.transactions;

import lombok.Data;

@Data
public class Student implements DailySession {

	private Attendence attendence;

	public Student(Attendence attendence) {
		this.attendence = attendence;
	}

	@Override
	public void attendLession() {

		System.out.println("attendding session >....");
	}

}
