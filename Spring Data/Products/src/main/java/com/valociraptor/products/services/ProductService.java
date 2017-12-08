package com.valociraptor.products.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.valociraptor.products.models.CategoriesProducts;
import com.valociraptor.products.models.Category;
import com.valociraptor.products.models.Product;
import com.valociraptor.products.repositories.CategoriesProductsRepo;
import com.valociraptor.products.repositories.CategoryRepo;
import com.valociraptor.products.repositories.ProductRepo;

@Service
public class ProductService {
	private final ProductRepo productRepo;
	private final CategoryRepo categoryRepo;
	private final CategoriesProductsRepo categoriesProductsRepo;
	
	public ProductService(ProductRepo productRepo, CategoryRepo categoryRepo, CategoriesProductsRepo categoriesProductsRepo) {
		this.categoryRepo = categoryRepo;
		this.productRepo = productRepo;
		this.categoriesProductsRepo = categoriesProductsRepo;
	}
	
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}

	
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	public Product findProduct(Long id) {
		Product product = productRepo.findOne(id);
		return product;
	}
	
	public Category findCategory(Long id) {
		Category category = categoryRepo.findOne(id);
		
		return category;
	}


	
	public void addProduct(CategoriesProducts catProd) {
		categoriesProductsRepo.save(catProd);

	}
	
}
	
	

