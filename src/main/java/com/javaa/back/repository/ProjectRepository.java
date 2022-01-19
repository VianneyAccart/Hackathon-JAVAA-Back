package com.javaa.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaa.back.entity.Project;

public interface ProjectRepository extends JpaRepository <Project, Long> {

}
