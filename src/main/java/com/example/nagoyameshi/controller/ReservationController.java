package com.example.nagoyameshi.controller;  //予約一覧ページを管理するコントローラー

import java.time.LocalTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Reservation;
import com.example.nagoyameshi.entity.Restaurants;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.ReservationInputForm;
import com.example.nagoyameshi.form.ReservationRegisterForm;
import com.example.nagoyameshi.repository.ReservationRepository;
import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.security.UserDetailsImpl;
import com.example.nagoyameshi.service.ReservationService;

@Controller
public class ReservationController {
  private final ReservationRepository reservationRepository;
  private final RestaurantRepository restaurantRepository;
  private final ReservationService reservationService;

  public ReservationController(ReservationRepository reservationRepository, RestaurantRepository restaurantRepository, ReservationService reservationService) {
    this.reservationRepository = reservationRepository;
    this.restaurantRepository = restaurantRepository;
    this.reservationService = reservationService;
  }

  @GetMapping("/reservations")
  public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable, Model model) {
    User user = userDetailsImpl.getUser();
    Page<Reservation>reservationPage = reservationRepository.findByUserOrderByCreatedAtDesc(user, pageable);

    model.addAttribute("reservationPage", reservationPage);

    return "reservations/index";
  }
  
  @GetMapping("/restaurants/{id}/reservations/input") //予約フォームの内容確認して、問題がなければ内容確認ページにリダイレクトさせる
  public String input(@PathVariable(name = "id") Integer id,
                      @ModelAttribute @Validated ReservationInputForm reservationInputForm,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes,
                      Model model)
  {
	  Restaurants restaurants = restaurantRepository.getReferenceById(id);
	  Integer numberOfPeople = reservationInputForm.getNumberOfPeople();
	  Integer capacity = restaurants.getCapacity();
	  String reservedTime = reservationRepository.getReservedTime();
	  
	  if(numberOfPeople !=null) {
		  if(!reservationService.isWithcapacity(numberOfPeople, capacity)) {
			  FieldError fieldError = new FieldError(bindingResult.getObjectName(), "numberOfPeople","予約人数が定員を超えています");
			  bindingResult.addError(fieldError);
		  }
	  } //SimpleDateFormat sdFormatDateTime = new SimpleDateFormat("HH:mm");

//10:40
//SimpleDateFormat sdFormatDateTime = new SimpleDateFormat("HH:mm:ss");
//sdFormatDateTime.parse(比較する時間の変数).compareTo(sdFormatDateTime.parse(比較する時間の変数))

		    LocalTime reservedTimeLocal = LocalTime.parse(reservedTime);
		    LocalTime openingTimeLocal = LocalTime.parse(restaurants.getOpeningTime());
		    LocalTime closingTimeLocal = LocalTime.parse(restaurants.getClosingTime());
	 if (reservedTime.isBefore(restaurants.getOpeningTime()) || reservedTime.isAfter(restaurants.getClosingTime())) {
		    // 時間外の場合、エラーメッセージをバインディング結果に追加
		    FieldError fieldError = new FieldError(
		        bindingResult.getObjectName(),  // オブジェクト名（フォームオブジェクトの名前）
		        "reservedTime",  // フィールド名
		        "営業時間外です"  // エラーメッセージ
		    );
		    bindingResult.addError(fieldError);  // バインディング結果にエラーを追加
		}
	  
	  
	  
	  
	  if(bindingResult.hasErrors()) {
		  model.addAttribute("restaurants", restaurants);
		  model.addAttribute("reservationInputForm", reservationInputForm);  //追加
		  model.addAttribute("errorMessage", "予約内容に不備があります");
		  return "restaurants/show";
	  }
	  
	  redirectAttributes.addFlashAttribute("reservationInputForm", reservationInputForm);
	  
	  return "redirect:/restaurants/{id}/reservations/confirm";
  }
  
  @GetMapping("/restaurants/{id}/reservations/confirm")  //予約確認ページを表示させる
  public String confirm(@PathVariable(name = "id") Integer id,
		  				@ModelAttribute ReservationInputForm reservationInputForm,
		  				@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
		  				Model model)
  {
	  Restaurants restaurants = restaurantRepository.getReferenceById(id);
	  User user = userDetailsImpl.getUser();
	  
	  //来店日と来店時間取得する
	  String reservedDate = reservationInputForm.getReservedDate();
	  //来店時間
	  String reservedTime = reservationInputForm.getReservedTime();
	  
	  ReservationRegisterForm reservationRegisterForm = new ReservationRegisterForm(restaurants.getId(),
			  																		user.getId(),
			  																		reservedDate.toString(),
			                                                                        reservedTime.toString(),
			                                                                        reservationInputForm.getNumberOfPeople()
			                                                                        );
	 
	  model.addAttribute("restaurants", restaurants);
	  model.addAttribute("reservationRegisterForm", reservationRegisterForm);
	 
	  return "reservations/confirm"; 
  }
  
  @PostMapping("/restaurants/{id}/reservations/create")  //予約フォームの送信先を担当する
  public String create(@ModelAttribute ReservationRegisterForm reservationRegisterForm) {
	  reservationService.create(reservationRegisterForm);
	  
	  return "redirect:/reservations?reserved";
  }
}