package com.springsecurity.springsecurity.document.exceptio;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.security.SignatureException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest request){
		Map<String,Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());
		return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerDeletedException.class)
	public ResponseEntity<Object> handleCustomerDeletedException(CustomerDeletedException ex, WebRequest request) {

		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerAlreadyExists.class)
	public ResponseEntity<Object> handleCustomerAlreadyExistsException(CustomerAlreadyExists ex,WebRequest request){
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	 @ExceptionHandler(SignatureException.class)
	    public ResponseEntity<Map<String, Object>> handleJwtSignatureException(SignatureException ex) {
	        Map<String, Object> errorDetails = new HashMap<>();
	        errorDetails.put("timestamp", LocalDateTime.now());
	        errorDetails.put("status", HttpStatus.UNAUTHORIZED.value());
	        errorDetails.put("error", "Invalid JWT Token");
	        errorDetails.put("message", ex.getMessage());

	        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
	    }

	 @ExceptionHandler(InvalidJwtException.class)
		public ResponseEntity<Object> handleInvalidJwtException(InvalidJwtException ex,WebRequest request){
			Map<String, Object> body = new HashMap<>();
			body.put("timestamp", LocalDateTime.now());
			body.put("message", ex.getMessage());

			return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
		}
	 
	 
	  @ExceptionHandler(BadCredentialsException.class)
	    public ResponseEntity<Map<String, String>> handleBadCredentialsException(BadCredentialsException ex) {
	        Map<String, String> response = new HashMap<>();
	        response.put("error", "Unauthorized");
	        response.put("message", ex.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
	    }
	    /*@ExceptionHandler(InvalidJwtException.class)
	    public ResponseEntity<Map<String, Object>> handleInvalidJwtException(InvalidJwtException ex) {
	        Map<String, Object> errorDetails = new HashMap<>();
	        errorDetails.put("timestamp", LocalDateTime.now());
	        errorDetails.put("status", HttpStatus.UNAUTHORIZED.value());
	        errorDetails.put("error", "Invalid JWT Token");
	        errorDetails.put("message", ex.getMessage());

	        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
	    }*/
}
