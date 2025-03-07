package com.springsecurity.springsecurity.document.exceptio;

public class CustomerDeletedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerDeletedException(String message) {
		super(message);
	}
}
