package com.example.nagoyameshi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer>  {
	List<Categories> findAll();  //カテゴリの結果を表示する
	
	}
