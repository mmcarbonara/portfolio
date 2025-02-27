package com.example.nagoyameshi.controller;

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

import com.example.nagoyameshi.entity.Categories;
import com.example.nagoyameshi.entity.Restaurants;
import com.example.nagoyameshi.repository.CategoriesRepository;
import com.example.nagoyameshi.repository.RestaurantRepository;

@Controller
@RequestMapping("/category")
public class CategoryController {
	private final RestaurantRepository restaurantRepository;
    private final CategoriesRepository categoriesRepository;
	
    public  CategoryController(RestaurantRepository restaurantRepository,CategoriesRepository categoriesRepository) {
		this.restaurantRepository = restaurantRepository;
		this.categoriesRepository = categoriesRepository; 
	}
	
@GetMapping("/search/{id}") //カテゴリ別で検索
	 public String index(@PathVariable(name = "id") Integer id,Model model, @PageableDefault(page = 0,size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {
				 List<Categories> categoriesList = categoriesRepository.findAll();  //全てのカテゴリを取得
		         Page<Restaurants> restaurantList = restaurantRepository.findByCategoriesId(id, pageable); //レストランの情報取得
				 
			   	model.addAttribute("categoriesList", categoriesList);
			  	model.addAttribute("restaurantList", restaurantList);
			   	
				return "index";
		}
}

 