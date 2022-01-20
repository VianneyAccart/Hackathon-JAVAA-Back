package com.javaa.back.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.javaa.back.dto.ProductProjectCategoryDto;
import com.javaa.back.entity.Product;
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
