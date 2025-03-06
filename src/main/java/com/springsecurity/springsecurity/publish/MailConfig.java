package com.springsecurity.springsecurity.publish;

import org.springframework.context.annotation.Configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
// its not need i added for i used main in other

	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.example.com"); // Replace with your SMTP host
		mailSender.setPort(587); // Common port for TLS, modify as per your SMTP server

		mailSender.setUsername("doddivenkatesh768@gmail.com"); // Your email
		mailSender.setPassword("scdrfqibktklewic"); // Your password

		// Additional mail properties
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}
}
