package com.example.nagoyameshi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer>  {
	
}