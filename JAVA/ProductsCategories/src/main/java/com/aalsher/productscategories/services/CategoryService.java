package com.aalsher.productscategories.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aalsher.productscategories.models.Category;
import com.aalsher.productscategories.models.Product;
import com.aalsher.productscategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	private CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	private List<Category> categories = new ArrayList<Category>();

	public List<Category> getCategory() {
		return (List<Category>) categoryRepository.findAll();
	}

	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	public Category findCategoryById(Long id) {
		return categoryRepository.findById(id);
	}

}
