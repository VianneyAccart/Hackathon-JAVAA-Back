package com.javaa.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaa.back.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository <Project, Long> {

}
