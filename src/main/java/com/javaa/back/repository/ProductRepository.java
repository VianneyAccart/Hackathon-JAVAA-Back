package com.javaa.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaa.back.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long>{
	public List<Product> findAllByIsMustHave(Boolean isMustHave);
}
