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

}
