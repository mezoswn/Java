package com.codingdojoassignments.axsos.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojoassignments.axsos.models.Category;
import com.codingdojoassignments.axsos.models.Product;
import com.codingdojoassignments.axsos.controllers.MainController;
import com.codingdojoassignments.axsos.services.ProductCategoryService;

@Controller
public class MainController {

	private ProductCategoryService procatService;

	public MainController(ProductCategoryService procatService) {
		super();
		this.procatService = procatService;
	}
	
	@RequestMapping("/")
	public String index(@ModelAttribute("category") Category category, Model model) {
		
		model.addAttribute("categories", this.procatService.getAllCategories());
		model.addAttribute("products", this.procatService.getAllProducts());
		
		return "index.jsp";
	}
	
	@RequestMapping("/category/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newCat.jsp";
	}
	
	@RequestMapping("/category/create")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
		} else {
			this.procatService.createCategory(category);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		model.addAttribute("category", this.procatService.getCategory(id));
		model.addAttribute("products", this.procatService.otherProducts(this.procatService.getCategory(id)));
		return "showCat.jsp";
	}
	
	@RequestMapping("/categories/add/products")
	public String addProductToCategory(@RequestParam(value = "product_id") Long product_id, @RequestParam(value = "category_id") Long category_id) {
		this.procatService.addProduct(product_id, category_id);
		System.out.println(this);
		return "redirect:/";
	}
	
	@RequestMapping("/product/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newPro.jsp";
	}
	
	@RequestMapping("/product/create")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
		} else {
			this.procatService.createProduct(product);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", this.procatService.getProduct(id));
		model.addAttribute("categories", this.procatService.otherCategories(this.procatService.getProduct(id)));
		return "showPro.jsp";
	}
	
	@RequestMapping("/products/add/categories")
	public String addCategoryToProduct(@RequestParam(value = "product_id") Long product_id, @RequestParam(value = "category_id") Long category_id) {
		this.procatService.addCategory(product_id, category_id);
		return "redirect:/";
	}
	
	
	
	
	
	
	
}
