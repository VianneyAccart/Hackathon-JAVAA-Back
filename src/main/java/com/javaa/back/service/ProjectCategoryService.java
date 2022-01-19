package com.javaa.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.javaa.back.dto.ProjectCategoryDto;
import com.javaa.back.entity.ProjectCategory;
import com.javaa.back.repository.ProjectCategoryRepository;

@Service
public class ProjectCategoryService {

	@Autowired
	ProjectCategoryRepository projectCategoryRepository;

	public List<ProjectCategory> findAll() {
		return projectCategoryRepository.findAll();
	}

	public ProjectCategory findOne(Long id) {
		Optional<ProjectCategory> optProjectCategory = projectCategoryRepository.findById(id);
		if (optProjectCategory.isPresent()) {
			return optProjectCategory.get();
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	public ProjectCategory save(ProjectCategoryDto projectCategoryDto) {
		ProjectCategory projectCategory = new ProjectCategory();
		projectCategory.setName(projectCategoryDto.getName());
		return projectCategoryRepository.save(projectCategory);
	}
	
	public void delete(Long id) {
		Optional<ProjectCategory> optProjectCategory = projectCategoryRepository.findById(id);
		if (optProjectCategory.isPresent()) {
			projectCategoryRepository.deleteById(id);
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

}
