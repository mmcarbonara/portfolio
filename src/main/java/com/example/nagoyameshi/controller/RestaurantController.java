package com.example.nagoyameshi.controller;  //店舗一覧ページを担当するコントローラー
//まだ検索ふぉーむ用の記載は何もしてないから、検索項目を入力したら、ここにも追記する(restaurantControlle)
//restaurant/index.htmlがブラウザに表示させるようにする

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.nagoyameshi.entity.Categories;
import com.example.nagoyameshi.entity.Restaurants;
import com.example.nagoyameshi.repository.CategoriesRepository;
import com.example.nagoyameshi.repository.RestaurantRepository;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
	private final RestaurantRepository restaurantRepository;
	private final CategoriesRepository categoriesRepository;
	
	public RestaurantController(RestaurantRepository restaurantRepository,CategoriesRepository categoriesRepository) {
		this.restaurantRepository = restaurantRepository;
		this.categoriesRepository = categoriesRepository;
	} 
	
   @GetMapping
    public String index(@RequestParam(name = "keyword", required = false) String keyword,   //キーワード検索
		                @RequestParam(name = "price", required = false) Integer price,  //値段検索
				     	@RequestParam(name = "categoriesId", required = false) Integer categories,  //カテゴリ検索
				    	@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
				    	Model model) 
{  
	Page<Restaurants> restaurantPage;
	
	 List<Categories> categoriesList = categoriesRepository.findAll();  //全てのカテゴリを取得
	 Page<Restaurants> restaurantList = restaurantRepository.findByCategoriesId(categories, pageable); //レストランの情報取得
	 
	if(keyword != null && !keyword.isEmpty()) {
		restaurantPage = restaurantRepository.findByNameLike("%" + keyword + "%", pageable);  //キーワード検索
	}	else if(price != null) {
        restaurantPage = restaurantRepository.findByPriceLessThanEqual(price, pageable);  //値段検索
	}      else if(categories !=null) {
		restaurantPage = restaurantRepository.findByCategoriesId(categories, pageable);  //カテゴリ検索
	}   else {
		restaurantPage = restaurantRepository.findAll(pageable);  //すべての結果表示
	}
	   
	
	model.addAttribute("restaurantPage", restaurantPage);
	model.addAttribute("keyword", keyword);
	model.addAttribute("price",price);
	model.addAttribute("categoriesId",categories);
	
   	model.addAttribute("categoriesList", categoriesList);
   	model.addAttribute("restaurantList", restaurantList);
	
	return "restaurants/index";
		}

}     