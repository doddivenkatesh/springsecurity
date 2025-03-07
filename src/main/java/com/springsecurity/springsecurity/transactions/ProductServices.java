package com.springsecurity.springsecurity.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductServices {

	@Autowired
	private ProductRepo prodctRepo;

	public void saveProductInfo() {
		Productsss product = new Productsss();
		for (int i = 1; i < 10; i++) {
			product.setId(i);
			product.setName("Test Product" + i);
			prodctRepo.saveProduct(product);
		}
	}
}
