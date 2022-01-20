package com.javaa.back.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javaa.back.dto.ProductDto;
import com.javaa.back.entity.Product;
import com.javaa.back.service.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> findAll() {
		return productService.findAll();
	}
	
	@GetMapping("/{id}")
	public Product findOne(@PathVariable(required = true) Long id) {
		return productService.findOne(id);
	}
	
	@GetMapping("/unavoidable")
	public List<Product> findAllByUnavoidable() {
		return productService.findAllByUnavoidable();
	}
	
	@PostMapping(consumes = { "multipart/form-data" })
	public Product save(@Valid ProductDto productDto, @RequestParam MultipartFile file) throws IllegalStateException, IOException {
		return productService.save(productDto, file);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Long id) throws IOException {
		productService.delete(id);
	}
}
