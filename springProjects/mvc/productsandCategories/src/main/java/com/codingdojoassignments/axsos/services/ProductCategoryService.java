package com.codingdojoassignments.axsos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojoassignments.axsos.models.Category;
import com.codingdojoassignments.axsos.models.Product;
import com.codingdojoassignments.axsos.repositories.CategoryRepository;
import com.codingdojoassignments.axsos.repositories.ProductRepository;

@Service
public class ProductCategoryService {
	
	private CategoryRepository catRepo;
	private ProductRepository proRepo;
	
	public ProductCategoryService(CategoryRepository catRepo, ProductRepository proRepo) {
		super();
		this.catRepo = catRepo;
		this.proRepo = proRepo;
	}
	
	public Product createProduct(Product product) {
		return proRepo.save(product);
	}
	
	public Category createCategory(Category category) {
		return catRepo.save(category);
	}
	
	public List<Product> getAllProducts() {
		return proRepo.findAll();
	}
	
	public List<Category> getAllCategories() {
		return catRepo.findAll();
	}
	
	public Product getProduct(Long id) {
		return this.proRepo.findById(id).orElse(null);
	}
	
	public Category getCategory(Long id) {
		return this.catRepo.findById(id).orElse(null);
	}
	
	public Product addProduct(Long prodId, Long catId) {
		Product product = proRepo.findById(prodId).orElse(null);
		Category category = catRepo.findById(catId).orElse(null);
		product.getCategories().add(category);
		return proRepo.save(product);
	}
	
	public Category addCategory(Long catId, Long prodId) {
		Product product = proRepo.findById(prodId).orElse(null);
		Category category = catRepo.findById(catId).orElse(null);
		category.getProducts().add(product);
		return catRepo.save(category);
	}
	
	public List<Product> otherProducts(Category category) {
		return this.proRepo.findByCategoriesNotContains(category);
	}
	
	public List<Category> otherCategories(Product product) {
		return this.catRepo.findByProductsNotContains(product);
	}
	
	
	
	

}
