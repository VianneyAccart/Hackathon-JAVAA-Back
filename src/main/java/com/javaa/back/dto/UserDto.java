package com.javaa.back.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.javaa.back.entity.Project;

public class UserDto {
	
	@NotBlank 
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	private List<Project> projects;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName; 
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	//Getters & Setters
	

}
