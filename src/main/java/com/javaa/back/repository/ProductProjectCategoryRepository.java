package com.javaa.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaa.back.entity.ProductProjectCategory;

@Repository
public interface ProductProjectCategoryRepository extends JpaRepository<ProductProjectCategory, Long>{

}
