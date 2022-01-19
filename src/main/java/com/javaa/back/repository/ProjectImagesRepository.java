package com.javaa.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaa.back.entity.ProjectImages;

@Repository
public interface ProjectImagesRepository extends JpaRepository<ProjectImages, Long>{

}
