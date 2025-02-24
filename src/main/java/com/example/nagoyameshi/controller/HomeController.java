package com.example.nagoyameshi.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.nagoyameshi.entity.Categories;
import com.example.nagoyameshi.repository.CategoriesRepository;
import com.example.nagoyameshi.repository.RestaurantRepository;
@Controller
public class HomeController {
	private final RestaurantRepository restaurantRepository;
    private final CategoriesRepository categoriesRepository;
	
	public  HomeController(RestaurantRepository restaurantRepository,CategoriesRepository categoriesRepository) {
		this.restaurantRepository = restaurantRepository;
		this.categoriesRepository = categoriesRepository; 
		
	}
	
   @GetMapping("/") //トップページでカテゴリ別に表示させたい
   public String index(Model model) {
			 List<Categories> categoriesList = categoriesRepository.findAll();  //全てのカテゴリを取得

		   	model.addAttribute("categoriesList", categoriesList);
			return "index";
		}

	}
	




