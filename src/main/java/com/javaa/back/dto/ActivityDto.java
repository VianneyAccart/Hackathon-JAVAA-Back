package com.javaa.back.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ActivityDto {
	@NotNull
	@NotBlank
	@Size(min = 2, max = 255)
	private String name;

	public String getName() {
		return name;
	}
	@Size (min=1)
	private Long[] categoryIds;

	public Long[] getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(Long[] categoryIds) {
		this.categoryIds = categoryIds;
	}

	public void setName(String name) {
		this.name = name;
	}

}
