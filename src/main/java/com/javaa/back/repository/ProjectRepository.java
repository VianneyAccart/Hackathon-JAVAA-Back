package com.javaa.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaa.back.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository <Project, Long> {
	public List<Project> findAllByProjectCategoryId(Long id);
	public List<Project> findAllByProjectCategoryIdAndBudgetBetween(Long id, Double min, Double max);
}	
