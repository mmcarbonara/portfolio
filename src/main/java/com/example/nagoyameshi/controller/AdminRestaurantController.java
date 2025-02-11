package com.example.nagoyameshi.controller;   //管理者用の各種店舗ページを制御するコントローラー



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.nagoyameshi.entity.Restaurants;
import com.example.nagoyameshi.form.RestaurantRegisterForm;
import com.example.nagoyameshi.repository.RestaurantRepository;

@Controller
@RequestMapping("/admin/restaurants")
public class AdminRestaurantController {
	private final RestaurantRepository restaurantRepository;
	
	public AdminRestaurantController(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository; 
	}
	
    @GetMapping
    public String index(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable, @RequestParam(name = "keyword", required = false) String keyword) {
    	Page<Restaurants> restaurantPage;  
    	
    	if (keyword != null && !keyword.isEmpty()) {
    		restaurantPage = restaurantRepository.findByNameLike("%" + keyword + "%" ,pageable); //エラーになるのはデータの中身がないから？
    	} else {
    		restaurantPage = restaurantRepository.findAll(pageable);
    	}
    		
    	model.addAttribute("restaurantPage",restaurantPage); 
    	model.addAttribute("keyword", keyword);
    	
    	return "admin/restaurants/index"; //管理者用の店舗一覧ページ
    }
    
    @GetMapping("/{id}")
    public String show(@PathVariable(name = "id") Integer id, Model model) {
    	Restaurants restaurant = restaurantRepository.getReferenceById(id);
    	
    	model.addAttribute("restaurant", restaurant);
    	
    	return "admin/restaurants/show"; //管理者用の店舗詳細ページ
    }
    
    @GetMapping("/register")
    public String register(Model model) {
    	model.addAttribute("restaurantRegisterForm", new RestaurantRegisterForm());
    	return "admin/restaurants/register";  //管理者用の店舗登録ページ　
    }
}