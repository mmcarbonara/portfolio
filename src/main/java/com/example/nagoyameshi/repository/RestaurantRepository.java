package com.example.nagoyameshi.repository;  //ユーザーが店舗名とカテゴリで検索できるようにする

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Restaurants;

public interface RestaurantRepository extends JpaRepository<Restaurants, Integer> {
	public Page<Restaurants> findByNameLike(String nameKeyword, Pageable pageable); //店舗名検索
	
	public Page<Restaurants> findByPriceLessThanEqual(Integer price, Pageable pageable); //値段で検索
	
	//public Page<Restaurants> findByCategoriesLike(String categoriesKeyword, Pageable pageable); //カテゴリで検索
	public Page<Restaurants> findByCategoriesId(Integer categoriesId, Pageable pageable); //カテゴリIDで検索
    
	List<Restaurants> findAllByOrderByCategories_IdAscCreatedAtDesc();
}

//List<Restaurants> findByCategoriesOrderByCreatedAtDesc(Categories categories);     // カテゴリ順で並べ替えたレストランのリストを取得