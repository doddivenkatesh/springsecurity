package com.springsecurity.springsecurity.publish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@EnableAsync
@Component
public class EventListener implements ApplicationListener<Event>{

	@Autowired
	private JavaMailSender emailSender;
	@Override
	public void onApplicationEvent(Event event) {
		
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		if(event != null) {
			try {
				helper = new MimeMessageHelper(message,true);
				helper.setFrom("doddivenkatesh768@gmail.com");
				helper.setTo(event.getEmail());
				helper.setSubject("FROM NOBRAINs");
				helper.setText("hii welcome to pune",true);
				emailSender.send(message);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
