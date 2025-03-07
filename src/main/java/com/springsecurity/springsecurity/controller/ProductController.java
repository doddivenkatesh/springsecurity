package com.springsecurity.springsecurity.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.springsecurity.document.entity.ProductEntity;
import com.springsecurity.springsecurity.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.annotation.Resource;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Resource(name = "productService")
	private ProductService productService;

	@GetMapping
	public List<ProductEntity> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public ProductEntity findById(@PathVariable("id") Long id) {
		return productService.getByProductId(id);
	}

	@PostMapping("/create")
	public ProductEntity save(@RequestBody ProductEntity productEntity) {
		return productService.save(productEntity);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id,
			@RequestBody ProductEntity updatedProduct) {
		ProductEntity updatedEntity = productService.updateProduct(id, updatedProduct);
		return ResponseEntity.ok(updatedEntity);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}

}
