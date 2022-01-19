package com.javaa.back.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaa.back.dto.UserDto;
import com.javaa.back.entity.User;
import com.javaa.back.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//create user
	@PostMapping
	public User save(@Valid UserDto userDto) {
	return userService.save(userDto);	
	}
	
	//delete user
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true)Long id) {
		userService.delete(id);		
	}

}
