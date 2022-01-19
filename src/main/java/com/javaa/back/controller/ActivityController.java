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

import com.javaa.back.dto.ActivityDto;
import com.javaa.back.entity.Activity;
import com.javaa.back.service.ActivityService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/activities")
public class ActivityController {

	@Autowired
	ActivityService activityService;
	
	@GetMapping
	public List<Activity> findAll() {
		return activityService.findAll();
	}
	
	@GetMapping("/{id}")
	public Activity findOne(@PathVariable Long id) {
		return activityService.findOne(id);
	}
	
	@PostMapping
	public Activity save(@Valid ActivityDto activityDto) {
		return activityService.save(activityDto);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		activityService.delete(id);
	}
	
}
