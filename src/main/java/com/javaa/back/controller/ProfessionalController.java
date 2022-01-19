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

import com.javaa.back.dto.ProfessionalDto;
import com.javaa.back.entity.Professional;
import com.javaa.back.service.ProfessionalService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/professionals")
public class ProfessionalController {

	@Autowired
	ProfessionalService professionalService;
	
	@GetMapping
	public List<Professional> findAll() {
		return professionalService.findAll();
	}
	
	@GetMapping("/{id}")
	public Professional findOne(@PathVariable Long id) {
		return professionalService.findOne(id);
	}
	
	@PostMapping
	public Professional save(@Valid ProfessionalDto professionalDto, @RequestParam MultipartFile file ) throws IllegalStateException, IOException {
		return professionalService.save(professionalDto, file);
	}
	
	@DeleteMapping("/{id}") 
	public void delete(@PathVariable Long id) throws IOException {
		professionalService.delete(id);
	}
	
}
