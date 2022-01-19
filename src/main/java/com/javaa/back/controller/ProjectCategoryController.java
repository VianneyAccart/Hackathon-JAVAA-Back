package com.javaa.back.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaa.back.dto.ProjectCategoryDto;
import com.javaa.back.entity.ProjectCategory;
import com.javaa.back.service.ProjectCategoryService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/project-category")
public class ProjectCategoryController {
	
	@Autowired
	ProjectCategoryService categoryService;
	
	@GetMapping
	public List<ProjectCategory> findAll() {
		return categoryService.findAll();
	}
	
	@GetMapping("/{id}")
	public ProjectCategory findOne(@PathVariable Long id) {
		return categoryService.findOne(id);
	}
	
	@PostMapping
	public ProjectCategory save(@Valid ProjectCategoryDto projectCategoryDto) {
		return categoryService.save(projectCategoryDto);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		categoryService.delete(id);
	}

}
