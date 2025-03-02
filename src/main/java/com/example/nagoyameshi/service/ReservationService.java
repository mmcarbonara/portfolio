package com.example.nagoyameshi.service;

import java.time.LocalDate;
import java.time.LocalTime;

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
		LocalDate reservedDate = LocalDate.parse(reservationRegisterForm.getReservedDate());
		
		reservation.setRestaurantId(restaurantId);
		reservation.setUser(user);
		reservation.setReservedDate(reservedDate);
		reservation.setNumberOfPeople(reservationRegisterForm.getNumberOfPeople());
		
		reservationRepository.save(reservation);
	}

	//予約人数が定員以下かどうか確認する
	public boolean isWithcapacity(Integer numberOfPeople, Integer capacity) {
		return numberOfPeople <= capacity;
	}
	
    
	// 予約時間が営業時間内であるかどうかを確認する
	//SimpleDateFormat sdFormatDateTime = new SimpleDateFormat("HH:mm:ss"); //StringからTimeに変換して比較する
	//public boolean isWithinBusinessHours(String reservedTime, String openingTime, String closingTime) {
	//	return !reservedTime.isBefore(openingTime) && !reservedTime.isAfter(closingTime);
//	}

	public boolean isWithinBusinessHours(LocalTime reservedTime, String openingTime, String closingTime) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	
	//金額を計算する
	public Integer calculateAmount(Integer numberOfPeople, Integer price) {
		int amount = price * (int)numberOfPeople;
		return amount;
	}
}
	//下記のは削除検討
	//public boolean isWithreservedTime(Integer reservedTime, Integer openingTime, Integer closingTime) {
	    // 予約時間が営業時間内であることを確認できた時のみ予約ができるようにする
	 //   return reservedTime >= openingTime && reservedTime <= closingTime;
//	}
	
    // 予約日が定休日（リスト内の日付）でないか確認する
	//public boolean isNotHoliday(LocalDate reservedDate, String holiday) {
	//    DayOfWeek dayOfWeek = reservedDate.getDayOfWeek();
	 //   return !dayOfWeek.toString().equalsIgnoreCase(holiday);
	
	

