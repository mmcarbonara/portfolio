package com.example.nagoyameshi.form;  //予約フォームから予約内容確認ページに入力内容を渡すフォーム

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.nagoyameshi.entity.Restaurants;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReservationInputForm {
	@NotBlank(message = "日程を入力してください")
	private String reservedDate;
	
	@NotBlank(message = "予約時間を選択してください")
	private String reservedTime;
	
	@NotNull(message = "来店人数を入力してください")
	@Min(value = 1, message = "来店人数は１名以上に設定してください")
	private Integer numberOfPeople; 
	
	//来店日時を取得する　
	public class Reservation {
	    private LocalDate reservedDate;  // 予約日を保持するフィールド
	    private LocalTime reservedTime;  // 予約時間を保持するフィールド
	//    private Restaurants restaurantsHoliday; //定休日


	    // 予約時間を取得するメソッド
	    public LocalTime getReservedTime() {
	        return reservedTime;
	    }
	    
	    //定休日を取得するメソッド
	    public Restaurants getRestaurantsHoliday() {
	    	return getRestaurantsHoliday();
	    }
	}
}
