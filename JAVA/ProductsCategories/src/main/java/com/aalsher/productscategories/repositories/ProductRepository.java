package com.aalsher.productscategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aalsher.productscategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	Product findById(Long id);
}
