package com.javaa.back.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.javaa.back.dto.ActivityDto;
import com.javaa.back.entity.Activity;
import com.javaa.back.entity.ProductProjectCategory;
import com.javaa.back.entity.ProjectCategory;
import com.javaa.back.repository.ActivityRepository;
import com.javaa.back.repository.ProjectCategoryRepository;

@Service
public class ActivityService {

	@Autowired
	ActivityRepository activityRepository;
	
	@Autowired
	ProjectCategoryRepository projectCategoryRepository;

	public List<Activity> findAll() {
		return activityRepository.findAll();
	}

	public Activity findOne(Long id) {
		Optional<Activity> optActivity = activityRepository.findById(id);
		if (optActivity.isPresent()) {
			return optActivity.get();
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	public Activity save(ActivityDto activityDto) {
		Activity activity = new Activity();
		activity.setName(activityDto.getName());
		List<ProjectCategory> categories = new ArrayList<>();
		for(Long id : activityDto.getCategoryIds()) {
			Optional<ProjectCategory> optCategory = projectCategoryRepository.findById(id);
			if(optCategory.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
			categories.add(optCategory.get());
		}
		activity.setProjectCategories(categories);
		return activityRepository.save(activity);
	}
	 
	public void delete(Long id) {
		Optional<Activity> optActivity = activityRepository.findById(id);
		if (optActivity.isPresent()) {
			activityRepository.deleteById(id);
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

}
