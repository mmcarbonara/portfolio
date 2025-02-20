package com.example.nagoyameshi.controller;  //店舗一覧ページを担当するコントローラー
//まだ検索ふぉーむ用の記載は何もしてないから、検索項目を入力したら、ここにも追記する(restaurantControlle)
//restaurant/index.htmlがブラウザに表示させるようにする

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.nagoyameshi.entity.Restaurants;
import com.example.nagoyameshi.repository.RestaurantRepository;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
	private final RestaurantRepository restaurantRepository;
	
	public RestaurantController(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	} 
	
@GetMapping
public String index(@RequestParam(name = "keyword", required = false) String keyword,
					@RequestParam(name = "categoriesId", required = false) Integer categories,
					@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
					Model model) 
{  
	Page<Restaurants> restaurantPage;
	
	if(keyword != null &&!keyword.isEmpty()) {
		restaurantPage = restaurantRepository.findByNameLike("%" + keyword + "%", pageable);
	}   else if(categories !=null) {
		restaurantPage = restaurantRepository.findByCategoriesLike("%" + categories+ "%", pageable);
	}   else {
		restaurantPage = restaurantRepository.findAll(pageable);
	}
	
	model.addAttribute("restaurantPage", restaurantPage);
	model.addAttribute("keyword", keyword);
	model.addAttribute("categoriesId",categories);
	
	return "restaurants/index";
}
}     