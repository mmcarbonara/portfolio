package com.example.nagoyameshi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Restaurants;
import com.example.nagoyameshi.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	public List<Review> findByRestaurant  (Restaurants restaurantId,Pageable pageable); //レビューの一覧を取得できるようにする
	public Page<Review> findByRestaurantId(Integer id, Pageable pageable);
}