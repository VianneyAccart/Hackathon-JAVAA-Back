package com.javaa.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaa.back.repository.ProjectCategoryRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/project-category")
public class ProjectCategoryController {
	
	@Autowired
	ProjectCategoryRepository projectCategoryRepository;

}
