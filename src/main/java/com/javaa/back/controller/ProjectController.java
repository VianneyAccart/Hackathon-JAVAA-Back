package com.javaa.back.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javaa.back.dto.ProjectDto;
import com.javaa.back.entity.Project;
import com.javaa.back.service.ProjectService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@GetMapping
	public List<Project> findAll() {
		return projectService.findAll();
	}

	@GetMapping("/{id}")
	public Project findOne(@PathVariable(required = true) Long id) {
		return projectService.findOne(id);
	}

	@PostMapping(consumes = { "multipart/form-data" })
	public Project save(@Valid @RequestPart("project") ProjectDto projectDto, @RequestPart("file") MultipartFile file[])
			throws IllegalStateException, IOException {
		return projectService.save(projectDto, file);
	}

}
