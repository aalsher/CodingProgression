package com.aalsher.productscategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aalsher.productscategories.models.Category;
import com.aalsher.productscategories.models.Product;
import com.aalsher.productscategories.services.CategoryService;
import com.aalsher.productscategories.services.ProductService;

@Controller
public class ProductsCategories {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductsCategories(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}

	@RequestMapping("/products/new")
	public String addDojo(@ModelAttribute("product") Product product, BindingResult result, Model model) {
		return "newproduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String createDojos(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
    		return "newproduct.jsp";
        }else{
        Product savedProduct = productService.addProduct(product);
    			return "redirect:/products/" + savedProduct.getId();
        }
	}
        
    	@RequestMapping("/categories/new")
    	public String addNinja(@ModelAttribute("category") Category category, BindingResult result, Model model) {
    		return "newcategory.jsp";
    	}
    	
    	@PostMapping("/categories/new")
    	public String createNinjas(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
            if (result.hasErrors()) {
        		return "newcategory.jsp";
            }else{
            	Category savedCategory = categoryService.addCategory(category);
        			return "redirect:/categories/" + savedCategory.getId();
            }
    	}
     
    	@RequestMapping("/products/{id}")
    	public String findDojoById(Model model, @PathVariable("id") Long id) {
    		Product product = productService.findProductById(id);
    		List<Category> productcategories = product.getCategories();
    		List<Category> allcategories = categoryService.getCategory();
    		model.addAttribute("product", product);
    		model.addAttribute("productcategories", productcategories);
    		model.addAttribute("allcategories", allcategories);
    		return "viewproduct.jsp";
    	}
    	
    	@PostMapping("/products/{id}")
    	public String addProductToCategory(Model model, @PathVariable("id") Long id, @RequestParam("category") Long categoryid) {
    		//fetch the selected product
    		Product product = productService.findProductById(id);
    		//save the added category from the form into a temporary variable
    		Category addedcategory = categoryService.findCategoryById(categoryid);
    		//fetch all of the categories the product belongs to, save that to a var
    		List<Category> productscategories = product.getCategories();
    		//add the new category to the temporary list of all of the product's categories
    		productscategories.add(addedcategory);
    		//set the temporary list to be the new full list of the product's categories
    		product.setCategories(productscategories);
    		//save the product as a whole with its new category
    		productService.addProduct(product);
    		return "redirect:/products/{id}";
    	}
    	
    	@RequestMapping("/categories/{id}")
    	public String findCategoriesById(Model model, @PathVariable("id") Long id) {
    		Category category = categoryService.findCategoryById(id);
    		List<Product> categoryproducts = category.getProducts();
    		List<Product> allproducts = productService.getProducts();
    		model.addAttribute("category", category);
    		model.addAttribute("categoryproducts", categoryproducts);
    		model.addAttribute("allproducts", allproducts);
    		return "viewcategory.jsp";
    	}
    	
    	@PostMapping("/categories/{id}")
    	public String addProduct(Model model, @PathVariable("id") Long id, @RequestParam("product") Long productid) {
    		//fetch the selected category
    		Category category = categoryService.findCategoryById(id);
    		//save the added product from the form into a temporary variable
    		Product addedproduct = productService.findProductById(productid);
    		//fetch all of the products under the selected category, save that to a var
    		List<Product> categoryproducts = category.getProducts();
    		//add the new product to the temporary list of all of the products that belong to that category
    		categoryproducts.add(addedproduct);
    		//set the temporary list to be the new full list of the category's products
    		category.setProducts(categoryproducts);
    		//save the category as a whole with its new product
    		categoryService.addCategory(category);
    		return "redirect:/categories/{id}";
    	}
     

}
