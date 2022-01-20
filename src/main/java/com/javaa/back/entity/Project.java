package com.javaa.back.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date createdAt;

	@OneToMany(mappedBy = "project")
	private List<ProjectImages> images ; 
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private List<ProductProjectCategory> productProjectCategory = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "project_category_id")
	private ProjectCategory projectCategory;


	@ManyToMany
	@JoinTable(name = "project_professional", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "professional_id"))
	private List<Professional> professionals = new ArrayList<>();

	
	//Getters&Setters
	
	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<ProjectImages> getImages() {
		return images;
	}

	public void setImages(List<ProjectImages> images) {
		this.images = images;
	}

	public List<ProductProjectCategory> getProductProjectCategory() {
		return productProjectCategory;
	}

	public void setProductProjectCategory(List<ProductProjectCategory> productProjectCategory) {
		this.productProjectCategory = productProjectCategory;
	}

	public List<Professional> getProfessionals() {
		return professionals;
	}

	public void setProfessionals(List<Professional> professionals) {
		this.professionals = professionals;
	}




	public ProjectCategory getProjectCategory() {
		return projectCategory;
	}

	public void setProjectCategory(ProjectCategory projectCategory) {
		this.projectCategory = projectCategory;
	}

}
