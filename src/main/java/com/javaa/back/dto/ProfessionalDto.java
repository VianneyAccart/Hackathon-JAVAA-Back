package com.javaa.back.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProfessionalDto {
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 255)
	private String name;

	private String image;

	@NotNull
	@NotBlank
	@Size(min = 2, max = 255)
	private String description;

	@NotNull
	private Long activityId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

}
