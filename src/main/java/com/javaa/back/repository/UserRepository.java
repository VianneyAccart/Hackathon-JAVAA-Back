package com.javaa.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaa.back.entity.User;

public interface UserRepository extends JpaRepository <User, Long> {

}
