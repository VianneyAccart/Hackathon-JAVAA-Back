package com.javaa.back.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.javaa.back.dto.ProductDto;
import com.javaa.back.entity.Product;
import com.javaa.back.entity.ProjectCategory;
import com.javaa.back.repository.ProductRepository;
import com.javaa.back.repository.ProjectCategoryRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProjectCategoryRepository projectCategoryRepository;

	@Autowired
	FileService fileService;

	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public List<Product> findAllByUnavoidable() {
		return productRepository.findAllByIsMustHave(true);
	}

	public Product findOne(Long id) {
		Optional<Product> optProduct = productRepository.findById(id);
		if (optProduct.isPresent()) {
			return optProduct.get();
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	public Product save(ProductDto productDto, MultipartFile file) throws IllegalStateException, IOException {
		String image = fileService.uploadFile(file);
		Product product = new Product();
		product.setImage(image);
		product.setPrice(productDto.getPrice());
		product.setTitle(productDto.getTitle());
		product.setUrl(productDto.getUrl());
		product.setIsMustHave(productDto.getIsMustHave());
		Optional<ProjectCategory> optProjectCategory = projectCategoryRepository
				.findById(productDto.getProjectCategoryId());
		if (optProjectCategory.isPresent()) {
			product.setProjectCategory(optProjectCategory.get());
			return productRepository.save(product);
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	public void delete(Long id) throws IOException {
		Optional<Product> optProduct = productRepository.findById(id);
		if (optProduct.isPresent()) {
			Product product = optProduct.get();
			fileService.deleteFile(product.getImage());
			productRepository.deleteById(id);
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

}
