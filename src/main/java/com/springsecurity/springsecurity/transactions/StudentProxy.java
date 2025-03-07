package com.springsecurity.springsecurity.transactions;

public class StudentProxy extends Student{

	public StudentProxy(Attendence attendence) {
		super(attendence);
	}
	
	/*@Override
	public void attendLession() {
		if(super.getAttendence().isPresent()) {
		super.attendLession();
		}
		else {
			throw new RuntimeException("Student is not present and cant attend");
		}
	}*/
	
	 @Override
	public void attendLession() {
		 if(!super.getAttendence().isPresent()) {
			 throw new RuntimeException("Student is not  present and cant attend lession");
		 }
		super.attendLession();
	}
	
	

}
