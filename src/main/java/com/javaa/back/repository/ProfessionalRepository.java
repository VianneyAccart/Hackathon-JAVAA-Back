package com.javaa.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaa.back.entity.Professional;

@Repository
public interface ProfessionalRepository extends JpaRepository <Professional, Long> {

}
