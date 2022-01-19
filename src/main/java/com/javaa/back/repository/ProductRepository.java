package com.javaa.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaa.back.entity.Product;

public interface ProductRepository extends JpaRepository <Product, Long>{

}
