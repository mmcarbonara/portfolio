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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.nagoyameshi.entity.Categories;
import com.example.nagoyameshi.entity.Restaurants;
import com.example.nagoyameshi.form.ReservationInputForm;
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
				     	@RequestParam(name = "order", required = false) String order, //並び替え
				    	@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
				    	Model model) 
{  
	Page<Restaurants> restaurantPage;
	
	 List<Categories> categoriesList = categoriesRepository.findAll();  //全てのカテゴリを取得
	 Page<Restaurants> restaurantList = restaurantRepository.findByCategoriesId(categories, pageable); //レストランの情報取得
	 
	if(keyword != null && !keyword.isEmpty()) {
		if (order !=null && order.equals("priceAsc")) {
			restaurantPage = restaurantRepository.findByNameLikeOrderByCreatedAtDesc("%" + keyword + "%" + keyword + "%", pageable);
		} else {
			restaurantPage = restaurantRepository.findByNameLikeOrderByPriceAsc("%" + keyword + "%" + keyword + "%", pageable);
		}
	}	else if(price != null) {
		if(order !=null && order.equals("priceAsc")) {
			restaurantPage = restaurantRepository.findByPriceLessThanEqualOrderByPriceAsc(price, pageable);  //値段検索	
		} else {
			restaurantPage = restaurantRepository.findByPriceLessThanEqualOrderByCreatedAtDesc(price, pageable);  //値段検索
		}
	}      else if(categories !=null) {
	   	if(order !=null && order.equals("priceAsc")) {
	   		restaurantPage = restaurantRepository.findByCategoriesIdOrderByCreatedAtAsc(categories, pageable);
	   	} else {
	   		restaurantPage = restaurantRepository.findByCategoriesIdOrderByCreatedAtDesc(categories, pageable);  //カテゴリ検索
	   	}
	}   else {
	 	if(order !=null && order.equals("priceAsc")) {
	 		restaurantPage = restaurantRepository.findAllByOrderByPriceAsc(pageable);  //すべての結果表示
	 	} else {
	 		restaurantPage = restaurantRepository.findAllByOrderByCreatedAtDesc(pageable); 
	 	}
	}
	   
	
	model.addAttribute("restaurantPage", restaurantPage);
	model.addAttribute("keyword", keyword);
	model.addAttribute("price",price);
	model.addAttribute("categoriesId",categories);
	model.addAttribute("order", order);
	
   	model.addAttribute("categoriesList", categoriesList);
  	model.addAttribute("restaurantList", restaurantList);
	
	return "restaurants/index";
		}
   
   @GetMapping("/{id}")  //店舗の詳細ページ
   public String show(@PathVariable(name = "id") Integer id, Model model) {
	   Restaurants restaurants = restaurantRepository.getReferenceById(id);
	   
	   model.addAttribute("restaurants", restaurants);
	   model.addAttribute("reservationInputForm", new ReservationInputForm()); //予約入力確認画面を渡す
	   
	   return "restaurants/show";
   }

}     