package com.javaa.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaa.back.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository <Activity, Long> {

}
