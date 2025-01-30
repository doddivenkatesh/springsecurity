package com.springsecurity.springsecurity.publish;

import org.springframework.context.ApplicationEvent;

import lombok.Data;

@Data
public class Event extends ApplicationEvent{

	
	private static final long serialVersionUID = 1L;
	
	public Event(Object source) {
		super(source);
	}


	private String message;
	private String email;
	private String otp;
	private boolean save;
	private boolean update;
	private boolean invite;
}
