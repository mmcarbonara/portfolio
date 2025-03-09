package com.example.nagoyameshi.repository;  //ユーザーが店舗名とカテゴリで検索できるようにする

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Restaurants;

public interface RestaurantRepository extends JpaRepository<Restaurants, Integer> {
	public Page<Restaurants> findByNameLike(String nameKeyword, Pageable pageable); //店舗名検索
	
	//public Page<Restaurants> findByPriceLessThanEqual(Integer price, Pageable pageable); //値段で検索
	public Page<Restaurants> findByCategoriesId(Integer categoriesId, Pageable pageable); //カテゴリIDで検索
	
	public Page<Restaurants> findByNameLikeOrderByCreatedAtDesc(String nameKeyword, Pageable pageable); //店舗名検索(新着順)
	public Page<Restaurants> findByNameLikeOrderByPriceAsc(String nameKeyword, Pageable pageable); //店舗名検索(安い順)
	public Page<Restaurants> findByPriceLessThanEqualOrderByCreatedAtDesc(Integer price, Pageable pageable); //値段で検索(新着順)
	public Page<Restaurants> findByPriceLessThanEqualOrderByPriceAsc(Integer price, Pageable pageable); //値段で検索(安い順)
	public Page<Restaurants> findByCategoriesIdOrderByCreatedAtDesc(Integer categoriesId, Pageable pageable); //カテゴリIDで検索(新着順)
	public Page<Restaurants> findByCategoriesIdOrderByPriceAsc(Integer categoriesId, Pageable pageable); //カテゴリIDで検索(安い順)
	public Page<Restaurants> findAllByOrderByCreatedAtDesc(Pageable pageable); //全てのデータを取得する（新着順）
	public Page<Restaurants> findAllByOrderByPriceAsc(Pageable pageable); //全てのデータを取得する(安い順)
	
	
	
    
	List<Restaurants> findAllByOrderByCategories_IdAscCreatedAtDesc();

	
}

