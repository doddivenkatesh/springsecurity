package com.springsecurity.springsecurity.transactions;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);
		context.registerShutdownHook();
		ProductServices productService=context.getBean("productService",ProductServices.class);
		productService.saveProductInfo();
		context.close();
	}
}
