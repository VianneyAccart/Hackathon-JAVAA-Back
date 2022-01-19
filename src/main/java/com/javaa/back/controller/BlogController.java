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

import com.javaa.back.dto.BlogDto;
import com.javaa.back.entity.Blog;
import com.javaa.back.service.BlogService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/blogs")
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	//Create 
	@PostMapping
	public Blog save(@Valid BlogDto blogDto, @RequestParam MultipartFile file) throws IllegalStateException, IOException {
		return blogService.save(blogDto, file);
	} 
	
	//Delete
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required=true)Long id) {
		blogService.delete(id);
	}
	
	//Get one
	@GetMapping("/{id}")
	public Blog getOne(@PathVariable(required=true) Long id){
		return blogService.getOne(id);
	}
	
	//Get All
	@GetMapping
	public List<Blog> findAll(){
		return blogService.findAll();
	}
	
	
 
}
