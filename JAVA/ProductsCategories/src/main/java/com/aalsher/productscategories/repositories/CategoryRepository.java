package com.aalsher.productscategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aalsher.productscategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	Category findById(Long id);
}

