package com.javaa.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.javaa.back.dto.UserDto;
import com.javaa.back.entity.User;
import com.javaa.back.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	//Get All
	public List<User> findAll(){
		return userRepository.findAll();
		}
	
	//Get one
	public User getOne(Long id) {
		Optional<User> optUser = userRepository.findById(id);
		if(optUser.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optUser.get();
	}
	
	//Create User
	public User save(UserDto userDto) {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		return userRepository.save(user);
	}
	
	//Delete User
	public void delete(Long id) {
		Optional<User> optUser = userRepository.findById(id);
		if (optUser.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		userRepository.deleteById(id);
	}
	

}
