package com.example.nagoyameshi.controller;  //予約一覧ページを管理するコントローラー

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
	  String reservedDate = reservationInputForm.getReservedDate();
	  
	  //定員がオーバーしてないか確認して、オーバーしてたらエラーメッセージ表示させる
	  if(numberOfPeople !=null) {    
		  if(!reservationService.isWithcapacity(numberOfPeople, capacity)) {
			  FieldError fieldError = new FieldError(bindingResult.getObjectName(), "numberOfPeople","予約人数が定員を超えています"); //エラーを取得してfieldErrorに渡す
			  bindingResult.addError(fieldError); //エラーの結果を追加する
		  }
		  
//	  // 予約日が月曜日かどうかをチェック
//	if (reservedDate != null && reservationService.isHoliday(reservedDate, restaurants.getHoliday())) {
//		       FieldError fieldError = new FieldError(bindingResult.getObjectName(), "reservationDate", "月曜日は定休日です。予約できません。"); //エラーを取得する
//		       bindingResult.addError(fieldError);
//		    }

		  
		  //営業時間以外の時間に予約したらエラーメッセージを表示させる
		    String reservedTime = reservationInputForm.getReservedTime();
		    if(!reservationService.isWithinBusinessHours(reservedTime, restaurants.getOpeningTime(), restaurants.getClosingTime())) {
		  	  bindingResult.addError(new FieldError("reservationInputForm", "reservedTime", "予約時間は営業時間内に設定してください"));
		    }
	  
	  
	  } 
	  
	  //エラー時には再度ページを表示させる
	  if(bindingResult.hasErrors()) {
		  model.addAttribute("restaurants", restaurants);
		  model.addAttribute("reservationInputForm", reservationInputForm);  
		  model.addAttribute("errorMessage", "予約内容に不備があります");
		  return "restaurants/show";
	  }
	  
	  //エラーがなければ確認ページへ
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
      //人数
	  Integer numberOfPeople = reservationInputForm.getNumberOfPeople(); 
	  
	  ReservationRegisterForm reservationRegisterForm = new ReservationRegisterForm(restaurants.getId(),
			  																		user.getId(),
			  																		reservationInputForm.getReservedDate(),
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