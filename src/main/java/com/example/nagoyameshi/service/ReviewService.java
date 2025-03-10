package com.example.nagoyameshi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Review;
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
    Review review = new Review();
    Review restaurantId = reviewRepository.getReferenceById(ReviewInputForm.getRestaurantId());
    
    review.setScore(reviewInputForm.getScore());
    review.setContent(reviewInputForm.getContent());


    reviewRepository.save(review);
    }
 }

