package com.javaa.back.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.javaa.back.dto.ProfessionalDto;
import com.javaa.back.entity.Activity;
import com.javaa.back.entity.Professional;
import com.javaa.back.repository.ActivityRepository;
import com.javaa.back.repository.ProfessionalRepository;

@Service
public class ProfessionalService {

	@Autowired
	ProfessionalRepository professionalRepository;
	
	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	FileService fileService;

	public List<Professional> findAll() {
		return professionalRepository.findAll();
	}

	public Professional findOne(Long id) {
		Optional<Professional> optProfessional = professionalRepository.findById(id);
		if (optProfessional.isPresent()) {
			return optProfessional.get();
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	public Professional save(ProfessionalDto professionalDto, MultipartFile file) throws IllegalStateException, IOException {
		String image = fileService.uploadFile(file);
		Professional professional = new Professional();
		Optional<Activity> optActivity = activityRepository.findById(professionalDto.getActivityId());
		if(optActivity.isPresent()) {
			professional.setActivity(optActivity.get());
			professional.setDescription(professionalDto.getDescription());
			professional.setImage(image);
			professional.setName(professionalDto.getName());
			return professionalRepository.save(professional);
		}else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	public void delete(Long id) throws IOException {
		Optional<Professional> optProfessional = professionalRepository.findById(id);
		if(optProfessional.isPresent()) {
			Professional professional = optProfessional.get();
			fileService.deleteFile(professional.getImage());
			professionalRepository.deleteById(id);
		}
	}

}
