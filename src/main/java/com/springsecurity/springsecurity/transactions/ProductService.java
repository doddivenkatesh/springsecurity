package com.springsecurity.springsecurity.transactions;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

	@Autowired
	private ProductRepo prodctRepo;
	public void saveProductInfo() {
		Product product = new Product();
		for(int i=1;i<10; i++) {
			product.setId(i);
			product.setName("Test Product" +i);
		prodctRepo.saveProduct(product);
		}
	}
}
