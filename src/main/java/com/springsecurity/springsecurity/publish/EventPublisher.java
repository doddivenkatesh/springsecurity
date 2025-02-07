package com.springsecurity.springsecurity.publish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


@Component
public class EventPublisher {

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	
	 public void publishJTEvent(final  String email) {
	        
	        System.out.println("Publishing JTEvent. ");
	        Event customerEmailEvent = new Event(this);
	        customerEmailEvent.setEmail(email);    
	        
	      
	        applicationEventPublisher.publishEvent(customerEmailEvent);
	    }
}
