package com.aalsher.productscategories.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aalsher.productscategories.models.Product;
import com.aalsher.productscategories.repositories.ProductRepository;


@Service
public class ProductService {
	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	private List<Product> products = new ArrayList<Product>();

	public List<Product> getProducts() {
		return (List<Product>) productRepository.findAll();
	}

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public Product findProductById(Long id) {
		return productRepository.findById(id);
	}

}
