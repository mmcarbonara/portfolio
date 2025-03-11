package com.example.nagoyameshi.controller; //レビュー機能コントローラー



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Restaurants;
import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.form.ReviewEditForm;
import com.example.nagoyameshi.form.ReviewInputForm;
import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.repository.ReviewRepository;
import com.example.nagoyameshi.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
  //  private ReviewService reviewService;
    private ReviewRepository reviewRepository;
    private RestaurantRepository restaurantRepository;
    private ReviewService reviewService;
    
	public ReviewController(ReviewRepository reviewRepository,RestaurantRepository restaurantRepository, ReviewService reviewService) {
		this.reviewRepository =reviewRepository;
		this.restaurantRepository = restaurantRepository;
		this.reviewService = reviewService;
	}

    @GetMapping("/review")//レビュー一覧ページを表示させたい
    public String index(@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,Model model) {
    	
    	Page<Review> reviewPage;
    	
    	reviewPage = reviewRepository.findAll(pageable);  //全ての店舗のデータを取得
    		
    	 model.addAttribute("reviewPage",reviewPage); 
    	
    	 return "review/index"; 
}
    @GetMapping("/restaurants/{id}/review")  //店舗詳細ページからレビュー投稿一覧を表示
    public String review(@PathVariable(name = "id") Integer id, 
    					Model model, 
    					@PageableDefault(page=0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {
         Restaurants restaurants = restaurantRepository.getReferenceById(id);
         
         Page<Review> reviewPage;
    	
    	reviewPage = reviewRepository.findByRestaurantId(id, pageable);  //特定店舗のデータのみ取得
         		
        model.addAttribute("restaurants", restaurants);
        model.addAttribute("reviewPage", reviewPage);
         
        return "review/index";
   }
   
    @GetMapping("/restaurants/{id}/review/input")  //レビューの投稿画面の表示
    public String reviewInput(@PathVariable(name = "id") Integer id, Model model) {
 	   Restaurants restaurants = restaurantRepository.getReferenceById(id);
 	   ReviewInputForm reviewInputForm = new ReviewInputForm(); //レストランのidを入れる
 	   reviewInputForm.setRestaurantId(id);
 	   
 	   model.addAttribute("restaurants", restaurants);
 	   model.addAttribute("reviewInputForm",reviewInputForm); //フォームを渡す

        return "review/input";  // レビュー投稿ページのテンプレートを返す
    }
    
    @GetMapping("/restaurants/{id}/review/{reviewId}/edit")  //レビューの編集ページの表示
    public String reviewEdit(@PathVariable(name = "id") Integer id, @PathVariable(name = "reviewId") Integer reviewId, Model model) {
    	Restaurants restaurants = restaurantRepository.getReferenceById(id);
  	    Review review = reviewRepository.getReferenceById(reviewId);
  	    ReviewEditForm reviewEditForm = new ReviewEditForm(review.getId(), review.getScore(), review.getContent());
 	   
  	    model.addAttribute("restaurants", restaurants); 
  	    model.addAttribute("review", review);
  	    model.addAttribute("reviewEditForm",reviewEditForm);  //フォームを渡す

        return "review/edit";  // 店舗編集ページのテンプレートを返す
    }
    
    @PostMapping("/restaurants/{id}/review/{reviewId}/delete") //店舗詳細ページからレビューの削除モーダル
    public String delete(@PathVariable(name = "id")  Integer id, @PathVariable(name = "reviewId") Integer reviewId, RedirectAttributes redirectAttributes) {
 	   reviewRepository.deleteById(reviewId);
 	   
 	   redirectAttributes.addFlashAttribute("successMessage", "レビューを削除しました");
 	   
 	  return "redirect:/restaurants/{id}";
    }
    
    @PostMapping("/review/restaurants/review/create") //レビュー登録
    public String create(@ModelAttribute @Validated ReviewInputForm reviewInputForm,BindingResult bindingResult, RedirectAttributes redirectAttriburtes) {
    	if(bindingResult.hasErrors()) {
    		return "review/input";
    	}
    	
    	reviewService.create(reviewInputForm);
    	redirectAttriburtes.addAttribute("successMessage", "レビューを登録しました");
    	
    	return "redirect:/review";
    }
    
    @PostMapping("/review/restaurants/review/update") //レビュー編集
    public String update(@ModelAttribute @Validated ReviewEditForm reviewEditForm,BindingResult bindingResult, RedirectAttributes redirectAttriburtes) {
    	if(bindingResult.hasErrors()) {
    		return "review/edit";
    	}
    	
    	reviewService.update(reviewEditForm);
    	redirectAttriburtes.addAttribute("successMessage", "レビューを更新しました");
    	
    	return "redirect:/edit";
    }
    
 
}