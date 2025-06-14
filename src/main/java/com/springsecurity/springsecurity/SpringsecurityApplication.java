package com.springsecurity.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.springsecurity.springsecurity.repo")
public class SpringsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	
	/*ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);
	context.registerShutdownHook();
	ProductService productService=context.getBean("ProductService",ProductService.class);
	productService.saveProductInfo();
	context.close();*/
	//https://chatgpt.com/share/67c9a660-a5ec-800f-a364-6d0af12eb9cd
}
}