package com.springsecurity.springsecurity.document.exceptio;


import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class DocumentServiceException extends RuntimeException{

	
	
	private static final long serialVersionUID = 1L;
	String message;

	public DocumentServiceException(String message) {
		super(message);
		this.message = message;
	}

	public DocumentServiceException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public DocumentServiceException(Throwable cause, String message) {
		super(cause);
		this.message = message;
	}

	public DocumentServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.message = message;
	}
}
