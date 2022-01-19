package com.javaa.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaa.back.entity.Activity;

public interface ActivityRepository extends JpaRepository <Activity, Long> {

}
