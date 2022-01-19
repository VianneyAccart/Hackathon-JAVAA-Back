package com.javaa.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.javaa.back.dto.ActivityDto;
import com.javaa.back.entity.Activity;
import com.javaa.back.repository.ActivityRepository;

@Service
public class ActivityService {

	@Autowired
	ActivityRepository activityRepository;

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
