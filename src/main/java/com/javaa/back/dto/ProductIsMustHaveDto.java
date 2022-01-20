package com.javaa.back.dto;

import javax.validation.constraints.NotNull;

public class ProductIsMustHaveDto {
	@NotNull
	private Long productId;
	@NotNull
	private Boolean isMustHave;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Boolean getIsMustHave() {
		return isMustHave;
	}

	public void setIsMustHave(Boolean isMustHave) {
		this.isMustHave = isMustHave;
	}

}
