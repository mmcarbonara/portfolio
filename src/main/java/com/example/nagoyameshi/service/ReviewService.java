package com.example.nagoyameshi.service;

import org.springframework.stereotype.Service;

import com.example.nagoyameshi.repository.ReviewRepository;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // 特定のレストランのレビューを取得
//    public List<Review> getReviewsByRestaurantId(Restaurants restaurantId) {
        // レストランIDに基づいてレビューを取得
      //  return reviewRepository.findByRestaurantId(restaurantId);
    }

