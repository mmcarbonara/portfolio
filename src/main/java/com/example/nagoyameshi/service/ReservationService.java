package com.example.nagoyameshi.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

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
		
	    //String型に変更する
	    LocalDate reservedDate = LocalDate.parse(reservationRegisterForm.getReservedDate());
	    reservation.setReservedDate(reservedDate);

	    LocalTime reservedTime = LocalTime.parse(reservationRegisterForm.getReservedTime());
	    reservation.setReservedTime(reservedTime);
		
		reservationRepository.save(reservation);
	}
	
	//予約人数が定員以下かどうか確認する
    public boolean isWithcapacity(Integer numberOfPeople, Integer capacity) {
		return numberOfPeople <= capacity;
	}
    
	//定休日でないかを確認する
   public boolean isHoliday(String reservedDate, String regularHolidays) {
	 
    // 予約日をLocalDateに変換
    LocalDate reservationLocalDate = LocalDate.parse(reservedDate);
       
    //データベースに入っているデータを配列に曜日の配列に変換する。複数の曜日があれば分割される。
  	List<String> regularHolidaysList =  Arrays.asList(regularHolidays.split(","));

    // 予約の曜日を取得
    DayOfWeek reservationDayOfWeek = reservationLocalDate.getDayOfWeek();
  	
  	//予約の曜日を取得先生アドバイス
  	DateTimeFormatter formmater = DateTimeFormatter.ofPattern("E", Locale.JAPANESE);
  	System.out.println(reservationLocalDate.format(formmater));
      
    // 定休日と照合
        return regularHolidaysList.stream()
                                           .anyMatch(holiday -> DayOfWeek.valueOf(holiday.toUpperCase())
                                                                         .equals(reservedDate));
        //.equals(reservationDayOfWeek));
    }
    
	 // 営業時間内かどうかを確認するメソッド
     public boolean isWithinBusinessHours(String reservedTime, String openingTime, String closingTime) {
	        //"HH:mm" の形式で文字列を LocalTime に変換
	      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	      DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	        // 文字列を LocalTime に変換
	       LocalTime reserved = LocalTime.parse(reservedTime, formatter);
	       LocalTime opening = LocalTime.parse(openingTime, dataFormatter);
	       LocalTime closing = LocalTime.parse(closingTime, dataFormatter);

	        // 予約時間が営業時間内かどうかを比較
	        return !reserved.isBefore(opening) && !reserved.isAfter(closing);
	    }
}
