package com.example.nagoyameshi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.form.ReviewEditForm;
import com.example.nagoyameshi.form.ReviewInputForm;
import com.example.nagoyameshi.repository.ReviewRepository;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    
    @Transactional  //レビューの登録機能
    public void create(ReviewInputForm reviewInputForm) {
    Review review = reviewRepository.getReferenceById(reviewInputForm.getRestaurantId());
    Review restaurantId = reviewRepository.getReferenceById(reviewInputForm.getRestaurantId());
    
    review.setScore(reviewInputForm.getScore());
    review.setContent(reviewInputForm.getContent());

    reviewRepository.save(review);
    }
    
    @Transactional  //レビューの編集機能
    public void update(ReviewEditForm reviewEditForm) {
    Review review = reviewRepository.getReferenceById(reviewEditForm.getRestaurantId());
    Review restaurantId = reviewRepository.getReferenceById(reviewEditForm.getRestaurantId());
    
    review.setScore(reviewEditForm.getScore());
    review.setContent(reviewEditForm.getContent());

    reviewRepository.save(review);
    }
 }

