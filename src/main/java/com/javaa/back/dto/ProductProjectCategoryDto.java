package com.javaa.back.dto;


public class ProductProjectCategoryDto {
	
	private Long[] product_id;
	 
	private Long[] project_id;
	
	private Boolean isMustHave;

	public Long[] getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long[] product_id) {
		this.product_id = product_id;
	}

	public Long[] getProject_id() {
		return project_id;
	}

	public void setProject_id(Long[] project_id) {
		this.project_id = project_id;
	}

	public Boolean getIsMustHave() {
		return isMustHave;
	}

	public void setIsMustHave(Boolean isMustHave) {
		this.isMustHave = isMustHave;
	}
	
	
}
