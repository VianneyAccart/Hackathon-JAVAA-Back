package com.javaa.back.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductDto {

	@NotNull
	@NotBlank
	@Size(min = 2, max = 255)
	private String title;

	@NotNull
	private Double price;

	@NotNull
	private Boolean isMustHave;

	@NotNull
	private Long projectCategoryId;

	@NotNull
	@NotBlank
	@Size(min = 2, max = 255)
	private String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getIsMustHave() {
		return isMustHave;
	}

	public void setIsMustHave(Boolean isMustHave) {
		this.isMustHave = isMustHave;
	}

	public Long getProjectCategoryId() {
		return projectCategoryId;
	}

	public void setProjectCategoryId(Long projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}

}
