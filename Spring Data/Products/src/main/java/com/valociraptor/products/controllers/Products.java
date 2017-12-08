package com.valociraptor.products.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valociraptor.products.models.CategoriesProducts;
import com.valociraptor.products.models.Category;
import com.valociraptor.products.models.Product;
import com.valociraptor.products.services.ProductService;

@Controller
public class Products {
	
	private final ProductService productService;
	
	public Products(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/products/new")
	public String newProducts(@ModelAttribute Product product) {
		
		return "newproduct.jsp";
	}
	
	@RequestMapping("/categories/new")
	public String newCategories(@ModelAttribute Category category) {
		
		return "newcategory.jsp";
	}
	
	
	@RequestMapping("/products/{id}")
	public String productDetail(Model model, @PathVariable("id") Long id, @ModelAttribute CategoriesProducts categoriesProducts) {
		
		
		 model.addAttribute("product", productService.findProduct(id));
		 model.addAttribute("categories", productService.allCategories());
		
		return "products.jsp";
	}
	
	
	@RequestMapping("/categories/{id}")
	public String categoryDetail(Model model, @PathVariable("id") Long id, @ModelAttribute CategoriesProducts categoriesProducts) {
		
		 model.addAttribute("category", productService.findCategory(id));
		 model.addAttribute("products", productService.allProducts());
		return "categories.jsp";
	}
	
	
	@PostMapping("/products")
	public String newProduct(@Valid @ModelAttribute Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newproduct.jsp";
		} else {
			productService.createProduct(product);
			return "redirect:/products/new";
		}
	}
	
	@PostMapping("/categories")
	public String newCategory(@Valid @ModelAttribute Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newcategory.jsp";
		} else {
			productService.createCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	@PostMapping("/addcat")
	public String addCategory(@ModelAttribute("catProd") CategoriesProducts catProd) {
		productService.addProduct(catProd);
		String prodId = Long.toString(catProd.getProduct().getId());
		return "redirect:/products/".concat(prodId);
	}
	


}
