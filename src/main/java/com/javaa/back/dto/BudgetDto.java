package com.javaa.back.dto;

import javax.validation.constraints.NotNull;

public class BudgetDto {
	@NotNull
	private Double budgetMin;
	@NotNull
	private Double budgetMax;
	@NotNull
	private Long projectCategoryId;

	public Double getBudgetMin() {
		return budgetMin;
	}

	public void setBudgetMin(Double budgetMin) {
		this.budgetMin = budgetMin;
	}

	public Double getBudgetMax() {
		return budgetMax;
	}

	public void setBudgetMax(Double budgetMax) {
		this.budgetMax = budgetMax;
	}

	public Long getProjectCategoryId() {
		return projectCategoryId;
	}

	public void setProjectCategoryId(Long projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}

}
