package com.springsecurity.springsecurity.document.exceptio;

public class CustomerAlreadyExists extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public CustomerAlreadyExists(String message) {
		super(message);
	}
}
