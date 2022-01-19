package com.javaa.back.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	private Date created_at;
	
	@OneToMany(mappedBy = "project")
	private List<ProjectImages> images ; 
	
	@OneToMany(mappedBy= "productProjectCategories")
	private List<Product> products;
	
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	
	@ManyToMany
	@JoinTable(name="project_professional",
	joinColumns = @JoinColumn(name="project_id"),
	inverseJoinColumns = @JoinColumn(name="professional_id"))
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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public List<ProjectImages> getImages() {
		return images;
	}

	public void setImages(List<ProjectImages> images) {
		this.images = images;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Professional> getProfessionals() {
		return professionals;
	}

	public void setProfessionals(List<Professional> professionals) {
		this.professionals = professionals;
	}


	
		

}
