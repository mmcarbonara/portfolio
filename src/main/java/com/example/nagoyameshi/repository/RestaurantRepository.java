package com.example.nagoyameshi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Restaurants;

public interface RestaurantRepository extends JpaRepository<Restaurants, Integer> {
	public Page<Restaurants> findByNameLike(String keyword, Pageable pageable); //検索ができるようになる
	
}