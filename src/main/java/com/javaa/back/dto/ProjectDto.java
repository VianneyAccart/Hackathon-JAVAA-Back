package com.javaa.back.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProjectDto {

	private Date createdAt;
	private String[] images;
	@NotNull
	private Long categoryId;
	@NotNull
	private Long userId;
	@Size(min = 1)
	private Long[] professionalsId;
	@Size(min = 1)
	private Long[] productsId;
	@NotNull
	private Boolean isMustHave;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long[] getProfessionalsId() {
		return professionalsId;
	}

	public void setProfessionalsId(Long[] professionalsId) {
		this.professionalsId = professionalsId;
	}

	public Long[] getProductsId() {
		return productsId;
	}

	public void setProductsId(Long[] productsId) {
		this.productsId = productsId;
	}

	public Boolean getIsMustHave() {
		return isMustHave;
	}

	public void setIsMustHave(Boolean isMustHave) {
		this.isMustHave = isMustHave;
	}

}
