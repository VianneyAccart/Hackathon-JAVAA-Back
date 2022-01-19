package com.javaa.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaa.back.entity.Blog;

public interface BlogRepository extends JpaRepository <Blog, Long> {

}
