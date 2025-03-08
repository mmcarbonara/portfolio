package com.example.nagoyameshi.controller; //管理者が管理するレビュー

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.repository.ReviewRepository;
import com.example.nagoyameshi.service.ReviewService;

@Controller
@RequestMapping("/admin/review")  //レビュー一覧
public class AdminReviewController {
	private final ReviewRepository reviewRepository;
	private final ReviewService reviewService;
	
	
	public AdminReviewController(ReviewRepository reviewRepository, ReviewService reviewService) {
		this.reviewRepository = reviewRepository; 
		this.reviewService = reviewService;
	}
	
	@PostMapping("/{id}/delete")  //レビュー投稿削除
	public String delete(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {
		reviewRepository.deleteById(id);
		
		redirectAttributes.addFlashAttribute("successMessage", "レビューを削除しました");
		
		return "redirect:/admin/review";
	}
}