package com.javaa.back.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.javaa.back.repository.ProductProjectCategoryRepository;


@Service
public class ProductProjectCategoryService {
	
	@Autowired
	ProductProjectCategoryRepository productProjectCategoryRepository;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProjectService projectService;

}
