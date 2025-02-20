package com.example.nagoyameshi.repository;  //ユーザーが店舗名とカテゴリで検索できるようにする

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Restaurants;

public interface RestaurantRepository extends JpaRepository<Restaurants, Integer> {
	public Page<Restaurants> findByNameLike(String nameKeyword, Pageable pageable); //店舗名検索
	
	public Page<Restaurants> findByCategoriesLike(String categoriesKeyword, Pageable pageable); //カテゴリで検索
	
}