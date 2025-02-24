package com.example.nagoyameshi.controller;   //管理者用の各種店舗ページを制御するコントローラー



import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Categories;
import com.example.nagoyameshi.entity.Restaurants;
import com.example.nagoyameshi.form.RestaurantEditForm;
import com.example.nagoyameshi.form.RestaurantRegisterForm;
import com.example.nagoyameshi.repository.CategoriesRepository;
import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.service.RestaurantService;

@Controller
@RequestMapping("/admin/restaurants")
public class AdminRestaurantController {
	private final RestaurantRepository restaurantRepository;
	private final RestaurantService restaurantService;
	private final CategoriesRepository categoriesRepository;
	
	public AdminRestaurantController(RestaurantRepository restaurantRepository, RestaurantService restaurantService, CategoriesRepository categoriesRepository) {
		this.restaurantRepository = restaurantRepository; 
		this.restaurantService = restaurantService;
		this.categoriesRepository = categoriesRepository;
	}
	
    @GetMapping
    public String index(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable, @RequestParam(name = "keyword", required = false) String keyword) {
    	Page<Restaurants> restaurantPage;  
    	
    	if (keyword != null && !keyword.isEmpty()) {
    		restaurantPage = restaurantRepository.findByNameLike("%" + keyword + "%" ,pageable); 
    	} else {
    		restaurantPage = restaurantRepository.findAll(pageable);
    	}
    		
    	model.addAttribute("restaurantPage",restaurantPage); 
    	model.addAttribute("keyword", keyword);
    	
    	return "admin/restaurants/index"; //管理者用の店舗一覧ページ
    }
    
    @GetMapping("/{id}")
    public String show(@PathVariable(name = "id") Integer id, Model model) {
    	Restaurants restaurants = restaurantRepository.getReferenceById(id);
    	
    	model.addAttribute("restaurants", restaurants);
    	
    	return "admin/restaurants/show"; //管理者用の店舗詳細ページ
    }
    
    @GetMapping("/register")
    public String register(Model model) {
    	model.addAttribute("restaurantRegisterForm", new RestaurantRegisterForm());
    	return "admin/restaurants/register";  //管理者用の店舗登録ページ　
    }
    
    @PostMapping("/create") //フォームの送信先担当するメソッドの追加
    public String create(@ModelAttribute @Validated RestaurantRegisterForm restaurantRegisterForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    	if(bindingResult.hasErrors()) { //エラーが存在するか確認する
    		return "admin/restaurants/register"; 
    	}
    	
    	restaurantService.create(restaurantRegisterForm); //エラーが存在しない場合は保存する
    	redirectAttributes.addFlashAttribute("successMessage", "店舗を登録しました");
    	
    	return "redirect:/admin/restaurants";
    }
    
    @GetMapping("/{id}/edit")  //管理者が店舗編集するページ用のメソッドの追加
    public String edit(@PathVariable(name ="id") Integer id, Model model) {
    	Restaurants restaurants = restaurantRepository.getReferenceById(id);
    	List<Categories> categoriesList = categoriesRepository.findAll();
    	String imageName = restaurants.getImageName();
    	RestaurantEditForm restaurantEditForm = new RestaurantEditForm(
    			restaurants.getId(), 
    			restaurants.getName(), 
    			null, 
    			restaurants.getDescription(), 
    			restaurants.getPrice(), 
    			restaurants.getOpeningTime(), 
    			restaurants.getClosingTime(),
    			restaurants.getCapacity(), 
    			restaurants.getHoliday(), 
    			restaurants.getPhoneNumber(), 
    			restaurants.getPostalCode(), 
    			restaurants.getAddress(), 
    			restaurants.getCategories()
    			);
    	
    	model.addAttribute("imageName", imageName);
    	model.addAttribute("categoriesList", categoriesList);
    	model.addAttribute("restaurantEditForm", restaurantEditForm);
    	
    	return "admin/restaurants/edit";
    }
 
    
    @PostMapping("/{id}/update") //管理者が店舗情報の更新するページ用のメソッド追加
    public String update(@ModelAttribute @Validated RestaurantEditForm restaurantEditForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    	if(bindingResult.hasErrors()) {
    		return "admin/restaurants/edit";
    	}
    	
    	restaurantService.update(restaurantEditForm);
    	redirectAttributes.addFlashAttribute("successMessage", "店舗情報更新しました");
    	
    	return "redirect:/admin/restaurants";
    	
    }
    
    @PostMapping("/{id}/delete") //削除用モーダル
    public String delete(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {
    	restaurantRepository.deleteById(id);
    	
    	redirectAttributes.addFlashAttribute("successMessage", "店舗を削除しました");
    	
    	return "redirect:/admin/restaurants";
    	}
}