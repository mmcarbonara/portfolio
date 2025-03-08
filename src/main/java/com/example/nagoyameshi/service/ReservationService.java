package com.example.nagoyameshi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Reservation;
import com.example.nagoyameshi.entity.Restaurants;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.ReservationRegisterForm;
import com.example.nagoyameshi.repository.ReservationRepository;
import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.repository.UserRepository;

@Service
public class ReservationService {
	private final ReservationRepository reservationRepository;
	private final RestaurantRepository restaurantRepository;
	private final UserRepository userRepository;
	
	public ReservationService(ReservationRepository reservationRepository, RestaurantRepository restaurantRepository,UserRepository userRepository) {
		this.reservationRepository = reservationRepository;
		this.restaurantRepository = restaurantRepository;
		this.userRepository = userRepository;
	}

	@Transactional  //フォームの送信先担当
	public void create(ReservationRegisterForm reservationRegisterForm) {
		Reservation reservation = new Reservation();
		Restaurants restaurantId = restaurantRepository.getReferenceById(reservationRegisterForm.getRestaurantId());
		User user = userRepository.getReferenceById(reservationRegisterForm.getUserId());
		
		reservation.setRestaurantId(restaurantId);
		reservation.setUser(user);
		reservation.setNumberOfPeople(reservationRegisterForm.getNumberOfPeople());	
		
		reservationRepository.save(reservation);
	}

	//予約人数が定員以下かどうか確認する
	public boolean isWithcapacity(Integer numberOfPeople, Integer capacity) {
		return numberOfPeople <= capacity;
	}
	
	//定休日（月曜でないかを確認する）
  //  public boolean isHoliday(String reservedDate) {
        // 予約日が月曜日なら定休日
   //     return reservedDate != null && reservedDate.getHoliday() == DayOfWeek.MONDAY;
 //   }
}
    
	// 予約時間が営業時間内であるかどうかを確認する
    // SimpleDateFormat sdFormatDateTime = new SimpleDateFormat("HH:mm"); //StringからTimeに変換して比較する
	// public boolean isWithinBusinessHours(String reservedTime, String openingTime, String closingTime) {
  //  	return !reservedTime.isBefore(openingTime) && !reservedTime.isAfter(closingTime);
	//}
	 
	 // 営業時間内かどうかを確認するメソッド
	  //  public boolean isWithinBusinessHours(String reservedTime, String openingTime, String closingTime) {
	        // "HH:mm" の形式で文字列を LocalTime に変換
	   //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

	        // 文字列を LocalTime に変換
	    //    LocalTime reserved = LocalTime.parse(reservedTime, formatter);
	    //    LocalTime opening = LocalTime.parse(openingTime, formatter);
	     //   LocalTime closing = LocalTime.parse(closingTime, formatter);

	        // 予約時間が営業時間内かどうかを比較
	     //   return !reserved.isBefore(opening) && !reserved.isAfter(closing);
	 //   }




	
	

