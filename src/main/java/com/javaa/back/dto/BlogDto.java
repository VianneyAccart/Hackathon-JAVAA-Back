package com.javaa.back.dto;

import javax.validation.constraints.NotBlank;


public class BlogDto {
	
	@NotBlank
	private String title;
	@NotBlank
	private String description;
	
	private String image;
	@NotBlank
	private String url;
	
	private Long projectCategoryId; 

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) { 
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getProjectCategoryId() {
		return projectCategoryId;
	}

	public void setProjectCategoryId(Long projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}
	
	

}
