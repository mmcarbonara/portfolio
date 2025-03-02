package com.example.nagoyameshi.controller; //レビュー機能コントローラー



import org.springframework.stereotype.Controller;

import com.example.nagoyameshi.service.ReviewService;

@Controller
public class ReviewController {
    private ReviewService reviewService;
    
	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
}