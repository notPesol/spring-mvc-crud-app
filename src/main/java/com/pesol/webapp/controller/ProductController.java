package com.pesol.webapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pesol.webapp.entity.Product;
import com.pesol.webapp.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	private final String REDIRECT_PATH = "redirect:/product";
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping
	public String index(@RequestParam(name = "sort", required = false)String sort, 
			@RequestParam(name = "search", required = false)String search, Model theModel) {
		
		List<Product> products = null;
		
		if(search != null) {
			products = productService.getProductsByName(search);
		} else {
			products = productService.getProducts(sort);
		}

		
		theModel.addAttribute("products", products);

		return "product/index";
	}

	@GetMapping("/{id}")
	public String detail(@PathVariable int id, Model theModel) {

		Product product = productService.getProduct(id);
		if (product == null) {
			return REDIRECT_PATH;
		}

		theModel.addAttribute("product", product);

		return "product/detail";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model theModel) {

		Product product = productService.getProduct(id);
		if (product == null) {
			return REDIRECT_PATH;
		}

		theModel.addAttribute("product", product);

		return "product/edit";
	}

	@PostMapping("/edit")
	public String update(@Valid @ModelAttribute Product product, BindingResult result) {
		
		if (result.hasErrors()) {
			return "product/edit";
		}

		productService.update(product);

		return REDIRECT_PATH;
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {

		productService.delete(id);

		return REDIRECT_PATH;
	}
	
	@GetMapping("/add")
	public String add(Model theModel) {
		
		theModel.addAttribute("product", new Product());
		
		return "product/add";
	}
	
	@PostMapping("/add")
	public String save(@Valid @ModelAttribute Product product, BindingResult result) {
		
		if(result.hasErrors()) {
			return "product/add";
		}
		
		productService.save(product);
		
		return REDIRECT_PATH;
	}

}
