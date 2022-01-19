package com.javaa.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaa.back.entity.Professional;

public interface ProfessionalRepository extends JpaRepository <Professional, Long> {

}
